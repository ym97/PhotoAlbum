import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Main {

	public JFrame mainFrame;
	JButton btnAdd, btnList, btnShow;
	final int max_photos = 10;
	static public ArrayList<ImageDetails> imageList = new ArrayList<ImageDetails>();
	// static Main window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Main window = new Main();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.getContentPane().setBackground(new Color(255, 250, 250));
		mainFrame.setBounds(100, 100, 479, 118);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel forTitle = new JPanel();
		forTitle.setForeground(new Color(0, 0, 51));
		JLabel lblDigitalPhotoAlbum = new JLabel("DIGITAL PHOTO ALBUM");
		lblDigitalPhotoAlbum.setForeground(new Color(0, 0, 51));
		lblDigitalPhotoAlbum.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblDigitalPhotoAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		forTitle.add(lblDigitalPhotoAlbum);

		JPanel forButtons = new JPanel();
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnShow = new JButton("SLIDESHOW");
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (imageList.size() != 0) {

					SlideShow ss = new SlideShow();

					ss.addFrame.setVisible(true);
				}

				else
					JOptionPane.showMessageDialog(mainFrame, "No photos yet !! ");
			}

		});

		btnList = new JButton("LIST");
		btnList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (imageList.size() != 0) {

					ListView lv = new ListView();

					lv.listFrame.setVisible(true);
				}

				else
					JOptionPane.showMessageDialog(mainFrame, "No photos yet !! ");
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (imageList.size() < max_photos) {
					AddNew an = new AddNew();

					an.addFrame.setVisible(true);
					an.list = imageList;

				} else {
					JOptionPane.showMessageDialog(mainFrame, "No more photos can be added !!", "FAIL",
							JOptionPane.OK_OPTION);
				}
			}
		});

		forButtons.add(btnAdd);
		forButtons.add(btnShow);
		forButtons.add(btnList);

		mainFrame.getContentPane().add(forTitle, BorderLayout.NORTH);
		mainFrame.getContentPane().add(forButtons, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}
}
