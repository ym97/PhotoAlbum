import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Font;

public class AddNew {

	JFrame addFrame;
	JTextField txtBrowse;
	JTextField txtTitle;
	TextArea textArea;
	JLabel lblChooseTheImage, lblTitle, lblAnnotation, lblDetails;
	JButton btnAddPhoto, btnBrowse;
	ImageDetails im;
	// ArrayList<ImageDetails> compl
	ArrayList<ImageDetails> list;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNew window = new AddNew();
					window.addFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddNew() {
		initialize();

		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				fc.setFileFilter(filter);
				fc.showOpenDialog(null);
				File ff = fc.getSelectedFile();
				String name = ff.getAbsolutePath();
				txtBrowse.setText(name);

			}
		});
		btnAddPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String add = new String(), nam = new String(), anno = new String();
				;

				add = txtBrowse.getText();
				nam = txtTitle.getText();
				anno = textArea.getText();

				if (add.length() == 0 || anno.length() == 0 || nam.length() == 0)
					JOptionPane.showMessageDialog(addFrame, "No field is expected to be empty");
				else {
					if (nam.length() <= 20) {

						if (anno.length() <= 100) {

							im = new ImageDetails(add, nam, anno);
							list.add(im);

							JOptionPane.showMessageDialog(addFrame, "Image is added to the album"/*
																									 * ,
																									 * "SUCCESS",
																									 * JOptionPane
																									 * .
																									 * OK_OPTION
																									 */);
							addFrame.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(addFrame, "Annotation exceeds limit");

						}

					} else {
						JOptionPane.showMessageDialog(addFrame, "Title exceeds limit");
					}
				}
			}

		});
	}

	private void initialize() {
		addFrame = new JFrame();
		addFrame.setBounds(100, 100, 332, 409);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.getContentPane().setLayout(null);

		txtBrowse = new JTextField();
		txtBrowse.setText("");
		txtBrowse.setBounds(20, 170, 196, 20);
		addFrame.getContentPane().add(txtBrowse);
		txtBrowse.setColumns(10);

		btnBrowse = new JButton("BROWSE");
		btnBrowse.setBounds(217, 169, 89, 23);
		addFrame.getContentPane().add(btnBrowse);

		txtTitle = new JTextField();
		txtTitle.setText("");
		txtTitle.setColumns(10);
		txtTitle.setBounds(110, 89, 196, 20);
		addFrame.getContentPane().add(txtTitle);

		textArea = new TextArea();
		textArea.setText("");
		textArea.setBounds(20, 227, 270, 89);
		addFrame.getContentPane().add(textArea);

		btnAddPhoto = new JButton("ADD PHOTO");
		btnAddPhoto.setBounds(99, 336, 112, 23);
		addFrame.getContentPane().add(btnAddPhoto);

		lblChooseTheImage = new JLabel("CHOOSE THE IMAGE LOCATION");
		lblChooseTheImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseTheImage.setBounds(20, 136, 196, 23);
		addFrame.getContentPane().add(lblChooseTheImage);

		lblTitle = new JLabel("TITLE");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(20, 91, 80, 17);
		addFrame.getContentPane().add(lblTitle);

		lblAnnotation = new JLabel("ANNOTATION");
		lblAnnotation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnnotation.setBounds(20, 201, 89, 20);
		addFrame.getContentPane().add(lblAnnotation);

		lblDetails = new JLabel("DETAILS OF THE IMAGE");
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setBounds(38, 11, 233, 33);
		addFrame.getContentPane().add(lblDetails);
		addFrame.setVisible(true);
	}
}
