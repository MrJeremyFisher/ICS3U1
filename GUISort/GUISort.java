package GUISort;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUISort {
	//FRAME
	private JFrame jf;
	//GENERAL VARIABLES
	private int Length = 50;
	private int CurrentAlgorithm = 0;
	private int Speed = 15;
	private int Comparisons = 0;
	private int ArrayAccesses = 0;
	@SuppressWarnings("unused") // for some reason it thinks "off" is never used, but it is
	private int off = 0;
	//GRAPH VARIABLES
	private final int SIZE = 600;
	private int current = -1;
	private int check = -1;
	private int width = SIZE / Length;
	private int type = 0;
	//ARRAYS
	private int[] list;
	private String[] types = { "Bar Graph", "Dot Plot" };
	private String[] algorithms = { "Selection Sort", "Bubble Sort", };

	//BOOLEANS
	private boolean sorting = false;
	private boolean shuffled = true;
	//UTIL OBJECTS
	SortingAlgorithms algorithm = new SortingAlgorithms();
	Random r = new Random();
	//PANELS
	JPanel tools = new JPanel();
	GraphCanvas canvas;
	//LABELS
	JLabel delayL = new JLabel("Delay :");
	JLabel msL = new JLabel(Speed + " ms");
	JLabel sizeL = new JLabel("Size :");
	JLabel lenL = new JLabel(Length + "");
	JLabel compareL = new JLabel("Comparisons : " + Comparisons);
	JLabel accessL = new JLabel("Array Accesses : " + ArrayAccesses);
	JLabel algorithmL = new JLabel("Algorithms");
	JLabel typeL = new JLabel("Graph Types");
	//DROP DOWN BOX
	@SuppressWarnings({ "unchecked", "rawtypes" }) // Suppress stupid warnings because I do not like them
	JComboBox alg = new JComboBox(algorithms);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox graph = new JComboBox(types);

	//BUTTONS
	JButton sort = new JButton("Sort");
	JButton shuffle = new JButton("Shuffle");
	//SLIDERS
	JSlider size = new JSlider(JSlider.HORIZONTAL, 1, 6, 1);
	JSlider speed = new JSlider(JSlider.HORIZONTAL, 0, 100, Speed);
	//BORDER STYLE
	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

	//CONSTRUCTOR
	public GUISort() {
		shuffleList(); //CREATE THE LIST
		initialize(); //INITIALIZE THE GUI
	}

	public void createList() {
		list = new int[Length]; //CREATES A LIST EQUAL TO THE LENGTH
		for (int i = 0; i < Length; i++) { //FILLS THE LIST FROM 1-Length
			list[i] = i + 1;
		}
	}

	public void shuffleList() {
		createList();
		for (int a = 0; a < 500; a++) { //SHUFFLE RUNS 500 TIMES
			for (int i = 0; i < Length; i++) { //ACCESS EACH ELEMENT OF THE LIST
				int rand = r.nextInt(Length); //PICK A RANDOM NUM FROM 0-Length
				int temp = list[i]; //SETS TEMP INT TO CURRENT ELEMENT
				list[i] = list[rand]; //SWAPS THE CURRENT INDEX WITH RANDOM INDEX
				list[rand] = temp; //SETS THE RANDOM INDEX TO THE TEMP
			}
		}
		sorting = false;
		shuffled = true;
	}

	public void initialize() {
		//SET UP FRAME
		jf = new JFrame();
		jf.setSize(800, 635);
		jf.setTitle("Sorting with a GUI");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().setLayout(null);

		//SET UP TOOLBAR
		tools.setLayout(null);
		tools.setBounds(5, 10, 180, 590);
		tools.setBorder(BorderFactory.createTitledBorder(loweredetched, "Controls"));

		//SET UP SORT BUTTON
		sort.setBounds(40, 150, 100, 25);
		tools.add(sort);

		//SET UP ALGORITHM LABEL
		algorithmL.setHorizontalAlignment(JLabel.CENTER);
		algorithmL.setBounds(40, 20, 100, 25);
		tools.add(algorithmL);

		//SET UP DROP DOWN
		alg.setBounds(30, 45, 120, 25);
		tools.add(alg);

		//SET UP SHUFFLE BUTTON
		shuffle.setBounds(40, 190, 100, 25);
		tools.add(shuffle);

		//SET UP DELAY LABEL
		delayL.setHorizontalAlignment(JLabel.LEFT);
		delayL.setBounds(10, 230, 50, 25);
		tools.add(delayL);

		//SET UP MS LABEL
		msL.setHorizontalAlignment(JLabel.LEFT);
		msL.setBounds(135, 230, 50, 25);
		tools.add(msL);

		//SET UP SPEED SLIDER
		speed.setMajorTickSpacing(5);
		speed.setBounds(55, 230, 75, 25);
		speed.setPaintTicks(false);
		tools.add(speed);

		//SET UP SIZE LABEL
		sizeL.setHorizontalAlignment(JLabel.LEFT);
		sizeL.setBounds(10, 275, 50, 25);
		tools.add(sizeL);

		//SET UP Length LABEL
		lenL.setHorizontalAlignment(JLabel.LEFT);
		lenL.setBounds(140, 275, 50, 25);
		tools.add(lenL);

		//SET UP SIZE SLIDER
		size.setMajorTickSpacing(50);
		size.setBounds(55, 275, 75, 25);
		size.setPaintTicks(false);
		tools.add(size);

		//SET UP COMPARISONS LABEL
		compareL.setHorizontalAlignment(JLabel.LEFT);
		compareL.setBounds(10, 320, 200, 25);
		tools.add(compareL);

		//SET UP ARRAY ACCESS LABEL
		accessL.setHorizontalAlignment(JLabel.LEFT);
		accessL.setBounds(10, 360, 200, 25);
		tools.add(accessL);

		//SET UP CANVAS FOR GRAPH
		canvas = new GraphCanvas();
		canvas.setBounds(190, 0, SIZE, SIZE);
		canvas.setBorder(BorderFactory.createLineBorder(Color.black));
		jf.getContentPane().add(tools);
		jf.getContentPane().add(canvas);

		//ADD ACTION LISTENERS
		sort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (shuffled) {
					sorting = true;
					Comparisons = 0;
					ArrayAccesses = 0;
				}

			}
		});
		shuffle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shuffleList();
				reset();
			}
		});
		speed.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				Speed = (int) speed.getValue();
				msL.setText(Speed + " ms");
			}
		});
		size.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = size.getValue();
				if (size.getValue() == 5)
					val = 4;
				Length = val * 50;
				lenL.setText(Length + "");
				if (list.length != Length)
					shuffleList();
				reset();
			}

		});

		sorting();
	}

	//SORTING STATE
	public void sorting() {
		if (sorting) {
			try {
				switch (CurrentAlgorithm) { //CURRENT ALGORITHM IS EXECUTED
				case 0:
					algorithm.selectionSort();
					break;
				case 1:
					algorithm.bubbleSort();
					break;
				default:
					algorithm.selectionSort();
					break;
				}
			} catch (IndexOutOfBoundsException e) {
			} //EXCEPTION HANDLER INCASE LIST ACCESS IS OUT OF BOUNDS
		}
		reset(); //RESET
		pause(); //GO INTO PAUSE STATE
	}

	//PAUSE STATE
	public void pause() {
		int i = 0;
		while (!sorting) { //LOOP RUNS UNTIL SORTING STARTS
			i++;
			if (i > 100)
				i = 0;
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
		sorting(); //EXIT THE LOOP AND START SORTING
	}

	//RESET SOME VARIABLES
	public void reset() {
		sorting = false;
		current = -1;
		check = -1;
		off = 0;
		Update();
	}

	//DELAY METHOD
	public void delay() {
		try {
			Thread.sleep(Speed);
		} catch (Exception e) {
		}
	}

	//UPDATES THE GRAPH AND LABELS
	public void Update() {
		width = SIZE / Length;
		canvas.repaint();
		compareL.setText("Comparisons : " + Comparisons);
		accessL.setText("Array Accesses : " + ArrayAccesses);
	}

	//MAIN METHOD
	public static void main(String[] args) {
		new GUISort();
	}

	@SuppressWarnings("serial")
	//SUB CLASS TO CONTROL THE GRAPH
	class GraphCanvas extends JPanel {

		public GraphCanvas() {
			setBackground(Color.black);
		}

		//PAINTS THE GRAPH
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < Length; i++) { //RUNS TROUGH EACH ELEMENT OF THE LIST
				int HEIGHT = list[i] * width; //SETS THE HEIGHT OF THE ELEMENT ON THE GRAPH
				if (type == 0) { //BAR GRAPH 
					g.setColor(Color.white); //DEFAULT COLOR
					if (current > -1 && i == current) {
						g.setColor(Color.green); //COLOR OF CURRENT
					}
					if (check > -1 && i == check) {
						g.setColor(Color.red); //COLOR OF CHECKING
					}
					//DRAWS THE BAR AND THE BLACK OUTLINE
					g.fillRect(i * width, SIZE - HEIGHT, width, HEIGHT);
					g.setColor(Color.black);
					g.drawRect(i * width, SIZE - HEIGHT, width, HEIGHT);
				}
			}
		}
	}

	//SUB CLASS FOR ALGORITHMS
	class SortingAlgorithms {

		public void selectionSort() {
			int c = 0;
			while (c < Length && sorting) {
				int sm = c;
				current = c;
				for (int i = c + 1; i < Length; i++) {
					if (!sorting)
						break;
					if (list[i] < list[sm]) {
						sm = i;
					}
					check = i;
					Comparisons++;
					ArrayAccesses += 2;
					Update();
					delay();
				}
				if (c != sm)
					swap(c, sm);
				c++;
			}
		}

		public void bubbleSort() {
			int c = 1;
			boolean noswaps = false;
			while (!noswaps && sorting) {
				current = Length - c;
				noswaps = true;
				for (int i = 0; i < Length - c; i++) {
					if (!sorting)
						break;
					if (list[i + 1] < list[i]) {
						noswaps = false;
						swap(i, i + 1);
					}
					check = i + 1;
					Comparisons++;
					ArrayAccesses += 2;
					Update();
					delay();
				}
				c++;
			}
		}

		public void swap(int i1, int i2) {
			int temp = list[i1];
			ArrayAccesses++;
			list[i1] = list[i2];
			ArrayAccesses += 2;
			list[i2] = temp;
			ArrayAccesses++;
		}

		public boolean checkSorted() {
			for (int i = 0; i < Length - 1; i++) {
				if (list[i] > list[i + 1]) {
					ArrayAccesses += 2;
					return false;
				}
			}
			return true;
		}
	}
}
