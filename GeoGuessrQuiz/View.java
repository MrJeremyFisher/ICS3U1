package geoguessrquiz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java 360 Sphere Image Viewer.
 *
 * @author Leonardo Ono (ono.leo@gmail.com), Modified slightly by Jeremy Favro
 */
public class View extends Canvas implements MouseMotionListener {

    private BufferedImage sphereImage;
    private final BufferedImage offscreenImage;
    private int[] sphereImageBuffer;
    private final int[] offscreenImageBuffer;
    private static final double FOV = Math.toRadians(110);
    private final double cameraPlaneDistance;
    private double[][][] rayVecs;
    private static final double ACCURACY_FACTOR = 2048;
    private static final int REQUIRED_SIZE = (int) (2 * ACCURACY_FACTOR);
    private double[] asinTable;
    private double[] atan2Table;
    private static final double INV_PI = 1 / Math.PI;
    private static final double INV_2PI = 1 / (2 * Math.PI);
    private double currentRotationX, currentRotationY;
    private int mouseX, mouseY;
    private BufferStrategy bs;
    BufferedImage sphereTmpImage;
    private GeoGuessrQuiz GeoGuessrQuiz;
    public static JFrame frame;

    public View() {

        try {
            switch (geoguessrquiz.GeoGuessrQuiz.questionNumber) {
                case 0:
                    break;
                case 1:
                    sphereTmpImage = ImageIO.read(getClass().getResourceAsStream("/EiffelTower.jpg")); // Eiffel Tower image
                    break;
                case 2:
                    sphereTmpImage = ImageIO.read(getClass().getResourceAsStream("/StatLib.jpg")); // Statue of Liberty image
                    break;
                case 3:
                    sphereTmpImage = ImageIO.read(getClass().getResourceAsStream("/GreatPyramids.jpg")); // Great Pyramids image
                    break;
                case 4:
                    sphereTmpImage = ImageIO.read(getClass().getResourceAsStream("/CNTower.jpg")); // CN Tower image
                    break;
                case 5:
                    sphereTmpImage = ImageIO.read(getClass().getResourceAsStream("/NorthKorea.jpg")); // Only spot in NK where they have a photo that isn't Pyongyang (or that one spot they don't let you see)
                    break;
            }
            sphereImage = new BufferedImage(sphereTmpImage.getWidth(), sphereTmpImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            sphereImage.getGraphics().drawImage(sphereTmpImage, 0, 0, null);
            sphereImageBuffer = ((DataBufferInt) sphereImage.getRaster().getDataBuffer()).getData();
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }
        offscreenImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        offscreenImageBuffer = ((DataBufferInt) offscreenImage.getRaster().getDataBuffer()).getData();
        cameraPlaneDistance = (offscreenImage.getWidth() / 2) / Math.tan(FOV / 2);
        createRayVecs();
        precalculateAsinAtan2();
        addMouseMotionListener(this);
    }

    private void createRayVecs() {
        rayVecs = new double[offscreenImage.getWidth()][offscreenImage.getHeight()][3]; // x, y, z
        for (int y = 0; y < offscreenImage.getHeight(); y++) {
            for (int x = 0; x < offscreenImage.getWidth(); x++) {
                double vecX = x - offscreenImage.getWidth() / 2;
                double vecY = y - offscreenImage.getHeight() / 2;
                double vecZ = cameraPlaneDistance;
                double invVecLength = 1 / Math.sqrt(vecX * vecX + vecY * vecY + vecZ * vecZ);
                rayVecs[x][y][0] = vecX * invVecLength;
                rayVecs[x][y][1] = vecY * invVecLength;
                rayVecs[x][y][2] = vecZ * invVecLength;
            }
        }
    }

    private void precalculateAsinAtan2() {
        asinTable = new double[REQUIRED_SIZE];
        atan2Table = new double[REQUIRED_SIZE * REQUIRED_SIZE];
        for (int i = 0; i < 2 * ACCURACY_FACTOR; i++) {
            asinTable[i] = Math.asin((i - ACCURACY_FACTOR) * 1 / ACCURACY_FACTOR);
            for (int j = 0; j < 2 * ACCURACY_FACTOR; j++) {
                double y = (i - ACCURACY_FACTOR) / ACCURACY_FACTOR;
                double x = (j - ACCURACY_FACTOR) / ACCURACY_FACTOR;
                atan2Table[i + j * REQUIRED_SIZE] = Math.atan2(y, x);
            }
        }
    }

    public void start() {
        createBufferStrategy(2);
        bs = getBufferStrategy();
        new Thread(() -> {
            boolean running = true;
            while (running) {
                Graphics2D g = (Graphics2D) bs.getDrawGraphics();
                draw(g);
                g.dispose();
                try {
                    bs.show();
                } catch (IllegalStateException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex); // I can't really fix this error, so I'm just gonna ignore it, cause it still works
                }
            }
        }).start();
    }

    private void draw(Graphics2D g) {
        double targetRotationX = (mouseY - (offscreenImage.getHeight() / 2)) * 0.025;
        double targetRotationY = (mouseX - (offscreenImage.getWidth() / 2)) * 0.025;
        currentRotationX += (targetRotationX - currentRotationX) * 0.25;
        currentRotationY += (targetRotationY - currentRotationY) * 0.25;
        double sinRotationX = Math.sin(currentRotationX);
        double cosRotationX = Math.cos(currentRotationX);
        double sinRotationY = Math.sin(currentRotationY);
        double cosRotationY = Math.cos(currentRotationY);
        double tmpVecX, tmpVecY, tmpVecZ;
        for (int y = 0; y < offscreenImage.getHeight(); y++) {
            for (int x = 0; x < offscreenImage.getWidth(); x++) {
                double vecX = rayVecs[x][y][0];
                double vecY = rayVecs[x][y][1];
                double vecZ = rayVecs[x][y][2];
                // rotate x
                tmpVecZ = vecZ * cosRotationX - vecY * sinRotationX;
                tmpVecY = vecZ * sinRotationX + vecY * cosRotationX;
                vecZ = tmpVecZ;
                vecY = tmpVecY;
                // rotate y
                tmpVecZ = vecZ * cosRotationY - vecX * sinRotationY;
                tmpVecX = vecZ * sinRotationY + vecX * cosRotationY;
                vecZ = tmpVecZ;
                vecX = tmpVecX;
                int iX = (int) ((vecX + 1) * ACCURACY_FACTOR);
                int iY = (int) ((vecY + 1) * ACCURACY_FACTOR);
                int iZ = (int) ((vecZ + 1) * ACCURACY_FACTOR);
                // https://en.wikipedia.org/wiki/UV_mapping
                double u = 0.5 + (atan2Table[iZ + iX * REQUIRED_SIZE] * INV_2PI);
                double v = 0.5 - (asinTable[iY] * INV_PI);
                int tx = (int) (sphereImage.getWidth() * u);
                int ty = (int) (sphereImage.getHeight() * (1 - v));
                int color = sphereImageBuffer[ty * sphereImage.getWidth() + tx];
                offscreenImageBuffer[y * offscreenImage.getWidth() + x] = color;
            }
        }
        g.drawImage(offscreenImage, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public static void main() {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            frame = new JFrame();
            frame.setTitle("Where is this?");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.getContentPane().add(view);
            frame.setResizable(false);
            frame.setVisible(true);
            view.requestFocus();
            view.start();
        });
    }

}

