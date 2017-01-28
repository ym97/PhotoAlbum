import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class ListView {

	JFrame listFrame;
	// ArrayList<ImageDetails> mylist;
	JList<String> list;
	JPanel listPanel, photoPanel, annoPanel, titlePanel;
	JLabel lblPhoto, lblTitle;
	// String nam[];
	TextArea txt;
	int maxht, maxwt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListView window = new ListView();
					window.listFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		listFrame = new JFrame();
		// listFrame.setBounds(100, 100, 834, 481);
		maxht = -1;
		maxwt = -1;
		for (int i = 0; i < Main.imageList.size(); i++) {
			ImageIcon ii = new ImageIcon(Main.imageList.get(i).getAddress());
			if (ii.getIconHeight() > maxht)
				maxht = ii.getIconHeight();
			if (ii.getIconWidth() > maxwt)
				maxwt = ii.getIconWidth();
		}
		listFrame.setSize(maxht, maxwt);
		listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel listPanel = new JPanel();

		String names[] = new String[Main.imageList.size()];
		for (int i = 0; i < Main.imageList.size(); i++) {
			names[i] = Main.imageList.get(i).getName();
		}
		list = new JList<String>(names);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int in = list.getSelectedIndex();
				String titl = Main.imageList.get(in).getName();
				String url = Main.imageList.get(in).getAddress();
				String ann = Main.imageList.get(in).getAnnotation();
				lblPhoto.setIcon(new ImageIcon(
						new ImageIcon(url).getImage().getScaledInstance(maxwt/3, maxht/3, Image.SCALE_DEFAULT)));
				photoPanel.add(lblPhoto);
				txt.setText(ann);
				txt.setEditable(false);
				lblTitle.setText(titl);

			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPanel.add(list);
		listFrame.getContentPane().add(listPanel, BorderLayout.WEST);

		photoPanel = new JPanel();
		lblPhoto = new JLabel();
		listFrame.getContentPane().add(photoPanel, BorderLayout.CENTER);

		annoPanel = new JPanel();
		txt = new TextArea();
		txt.setColumns(80);
		txt.setRows(3);
		annoPanel.add(txt);
		listFrame.getContentPane().add(annoPanel, BorderLayout.SOUTH);

		titlePanel = new JPanel();
		lblTitle = new JLabel();
		lblTitle.setFont(new Font("Segoe WP Black", Font.BOLD, 15));
		lblTitle.setText("TITLE");
		titlePanel.add(lblTitle);
		listFrame.getContentPane().add(titlePanel, BorderLayout.NORTH);

	}

}
