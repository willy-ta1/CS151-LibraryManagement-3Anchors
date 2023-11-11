package librarymanagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnterBookFrame {
	EnterBookFrame(Library library, JFrame frame) {
		JFrame addBookFrame = new JFrame();
		addBookFrame.setSize(new Dimension(600,600));
		
		JLabel titleLabel = new JLabel("Title: ");
		JTextField titleField = new JTextField();
		JLabel authorLabel = new JLabel("Author ");
		JTextField authorField = new JTextField();
		JPanel panelCenter = new JPanel(new GridLayout(2,2,5,40));
		
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel(); 
		JPanel panelNorth = new JPanel();
		JLabel title = new JLabel("Add book");
		
		JButton addBook = new JButton("Add book");
		
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		panelWest.setPreferredSize(new Dimension(195,200));
		panelEast.setPreferredSize(new Dimension(195,200));
		panelSouth.setPreferredSize(new Dimension(200,160));
		panelSouth.add(addBook);
		panelNorth.add(title);
		panelNorth.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		panelNorth.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
		panelNorth.setPreferredSize(new Dimension(600,230));
//		panelNorth.setBackground(Color.red);
		panelNorth.add(Box.createRigidArea(new Dimension(0,350)));
		
		panelCenter.add(titleLabel);
		panelCenter.add(titleField);
		panelCenter.add(authorLabel);
		panelCenter.add(authorField);
		
		addBookFrame.add(panelCenter, BorderLayout.CENTER);
		addBookFrame.add(panelNorth, BorderLayout.NORTH);
		addBookFrame.add(panelWest, BorderLayout.WEST);
		addBookFrame.add(panelEast, BorderLayout.EAST);
		addBookFrame.add(panelSouth, BorderLayout.SOUTH);
		
		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame addException = new JFrame("Add Excepotion");
				JPanel addExceptionPanel = new JPanel();
				
				try {
					if (titleField.getText().length() < 1) {
						throw new AddRemoveBookException.EmptyTitle();
					}
					if (authorField.getText().length() < 1) {
						throw new AddRemoveBookException.EmptyAuthor();
					}	
					
					library.addBook(new Book(titleField.getText(), authorField.getText()));
					addBookFrame.dispose();
					frame.dispose();
					new LibraryAdminCatalogMenu(library);
					
					
				} catch(AddRemoveBookException.EmptyTitle noTitle) {
					JLabel exceptionMessage = new JLabel(noTitle.getMessage());
					addExceptionPanel.add(exceptionMessage);
					addException.add(addExceptionPanel);
					addException.setVisible(true);
				} catch(AddRemoveBookException.EmptyAuthor noAuthor) {
					JLabel exceptionMessage = new JLabel(noAuthor.getMessage());
					addExceptionPanel.add(exceptionMessage);
					addException.add(addExceptionPanel);
					addException.setVisible(true);
				}
				

				
//				library.addBook(null);
				
			}
			
		});

		
		addBookFrame.setVisible(true);
		
		
	}
}
