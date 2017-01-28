import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SlideShow {

	JFrame addFrame;
	int curr_index = 0;
	JButton btnLeft, btnRight;
	TextArea txt;
	int maxht, maxwt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlideShow window = new SlideShow();
					window.addFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SlideShow() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addFrame = new JFrame();
		maxht = -1;
		maxwt = -1;
		for (int i = 0; i < Main.imageList.size(); i++) {
			ImageIcon ii = new ImageIcon(Main.imageList.get(i).getAddress());
			if (ii.getIconHeight() > maxht)
				maxht = ii.getIconHeight();
			if (ii.getIconWidth() > maxwt)
				maxwt = ii.getIconWidth();
		}
		addFrame.setSize(872, 703);
	//	addFrame.setBounds(100, 100, 942, 703);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel forTitle = new JPanel();
		JLabel lblTitle = new JLabel(Main.imageList.get(curr_index).getName());
		lblTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTitle.setForeground(new Color(0, 0, 102));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		forTitle.add(lblTitle);
		addFrame.getContentPane().add(forTitle, BorderLayout.NORTH);

		JPanel forPhoto = new JPanel();
		JLabel lblPhoto = new JLabel();
		lblPhoto.setIcon(new ImageIcon(new ImageIcon(Main.imageList.get(curr_index).getAddress()).getImage()
				.getScaledInstance(maxwt / 3, maxht / 3, Image.SCALE_DEFAULT)));
		forPhoto.add(lblPhoto);
		addFrame.getContentPane().add(forPhoto, BorderLayout.CENTER);

		btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curr_index > 0) {
					curr_index--;
					lblPhoto.setIcon(new ImageIcon(new ImageIcon(Main.imageList.get(curr_index).getAddress()).getImage()
							.getScaledInstance(maxwt / 3, maxht / 3, Image.SCALE_DEFAULT)));
					lblTitle.setText(Main.imageList.get(curr_index).getName());
					txt.setText(Main.imageList.get(curr_index).getAnnotation());
				}
			}
		});
		btnLeft.setToolTipText("Click to view previous image");
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (curr_index < Main.imageList.size()) {
					curr_index++;
					lblPhoto.setIcon(new ImageIcon(new ImageIcon(Main.imageList.get(curr_index).getAddress()).getImage()
							.getScaledInstance(maxwt / 3, maxht / 3, Image.SCALE_DEFAULT)));
					lblTitle.setText(Main.imageList.get(curr_index).getName());
					txt.setText(Main.imageList.get(curr_index).getAnnotation());
				}

			}
		});
		btnRight.setToolTipText("Click to view next image");
		JPanel forLeft = new JPanel();
		JPanel forRight = new JPanel();
		JPanel forAnno = new JPanel();
		forLeft.setLayout(new BorderLayout(0, 0));
		forLeft.add(btnLeft);
		forRight.setLayout(new BorderLayout(0, 0));
		forRight.add(btnRight);
		addFrame.getContentPane().add(forLeft, BorderLayout.WEST);
		addFrame.getContentPane().add(forRight, BorderLayout.EAST);

		txt = new TextArea();
		txt.setText(Main.imageList.get(curr_index).getAnnotation());
		txt.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 12));
		txt.setColumns(80);
		txt.setRows(4);
		forAnno.add(txt);
		addFrame.getContentPane().add(forAnno, BorderLayout.SOUTH);
	}

}
