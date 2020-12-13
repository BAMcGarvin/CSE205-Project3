// ***************************************************************************************************************************
// CLASS: View
//
// CSE 205: Object Oriented Programming and Data Structures
// Session A Fall 2018
// Project 3
//
// AUTHOR
// Bradley McGarvin
// ***************************************************************************************************************************

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI.
 */
public class View extends JFrame implements ActionListener {

   public static final int FRAME_WIDTH  = 500;

   public static final int FRAME_HEIGHT = 250;

   // Declare instance variables
   private JButton         mClearButton;

   private JTextField[]    mExamText;

   private JButton         mExitButton;

   private JTextField[]    mHomeworkText;

   private Project3        mMain;

   private JButton         mSaveButton;

   private JButton         mSearchButton;

   private JTextField      mSearchText;

   private Student         mStudent;

   /**
    * View()
    *
    * The View constructor creates the GUI interface and
    * makes the frame visible at the end.
    */
   public View(Project3 pMain) {

      // Save a reference to the Main object pMain in mMain.
      mMain = pMain;

      // PSEUDOCODE:
      // Create a JPanel named panelSearch which uses the
      // FlowLayout.
      // Add a JLabel "Student Name: " to panelSearch
      // Create mSearchText and make the field 25 cols wide
      // Add mSearchText to the panel
      // Create mSearchButton
      // Make this View the action listener for the button
      // Add the button to the panel
      JPanel panelSearch = new JPanel();
      panelSearch.add( new JLabel( "Student Name: " ) );
      mSearchText = new JTextField( 25 );
      panelSearch.add( mSearchText );
      mSearchButton = new JButton( "Search" );
      mSearchButton.addActionListener( this );
      panelSearch.add( mSearchButton );

      // PSEUDOCODE:
      // Create a JPanel named panelHomework which uses the
      // FlowLayout.
      // Add a JLabel "Homework: " to the panel
      // Create mHomeworkText which is an array of
      // CourseConstants.NUM_HOMEWORKS JTextFields
      // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
      // Create textfield mHomeworkText[i] displaying 5 cols
      // Add mHomeworkText[i] to the panel
      // End For
      JPanel panelHomework = new JPanel();
      panelHomework.add( new JLabel( "Homework: " ) );
      mHomeworkText = new JTextField[CourseConstants.NUM_HOMEWORKS];
      for ( int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++ ) {
         mHomeworkText[i] = new JTextField( 5 );
         panelHomework.add( mHomeworkText[i] );
      }

      // Create the exam panel which contains the "Exam: "
      // label and the two exam text fields. The pseudocode
      // is omitted
      // because this code is very similar to the code that
      // creates the panelHomework panel.
      JPanel panelExam = new JPanel();
      panelExam.add( new JLabel( "Exam: " ) );
      mExamText = new JTextField[CourseConstants.NUM_EXAMS];
      for ( int k = 0; k <= CourseConstants.NUM_EXAMS - 1; k++ ) {
         mExamText[k] = new JTextField( 5 );
         panelExam.add( mExamText[k] );
      }

      // PSEUDOCODE:
      // Create a JPanel named panelButtons using
      // FlowLayout.
      // Create the Clear button mClearButton.
      // Make this View the action listener for
      // mClearButton.
      // Add the Clear button to the panel.
      // Repeat the three above statements for the Save
      // button.
      // Repeat the three above statements for the Exit
      // button.
      JPanel panelButtons = new JPanel();
      mClearButton = new JButton( "Clear" );
      mClearButton.addActionListener( this );
      panelButtons.add( mClearButton );
      mSaveButton = new JButton( "Save" );
      mSaveButton.addActionListener( this );
      panelButtons.add( mSaveButton );
      mExitButton = new JButton( "Exit" );
      mExitButton.addActionListener( this );
      panelButtons.add( mExitButton );

      // PSEUDOCODE:
      // Create a JPanel named panelMain using a vertical
      // BoxLayout.
      // Add panelSearch to panelMain.
      // Add panelHomework to panelMain.
      // Add panelExam to panelMain.
      // Add panelButtons to panelMain.
      JPanel panelMain = new JPanel();
      panelMain.setLayout( new BoxLayout( panelMain, BoxLayout.Y_AXIS ) );
      panelMain.add( panelSearch );
      panelMain.add( panelHomework );
      panelMain.add( panelExam );
      panelMain.add( panelButtons );

      // Initialize the remainder of the frame, add the main
      // panel to the frame, and make the frame visible.
      setTitle( "Gradebookulator" );
      setSize( FRAME_WIDTH, FRAME_HEIGHT );
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      add( panelMain );
      setVisible( true );
   }

   /**
    * actionPerformed()
    *
    * Called when one of the JButtons is clicked. Detects
    * which button was clicked and handles it.
    */
   @Override
   public void actionPerformed(ActionEvent pEvent) {
      String action = pEvent.getActionCommand();

      if ( action == "Search" ) {
         String lastName = mSearchText.getText();

         if ( lastName == null ) {
            messageBox( "Please enter the student's last name." );
         }
         else {
            mStudent = mMain.search( lastName );
            if ( mStudent == null ) {
               messageBox( "Student not found. Try again." );
            }
            else {
               displayStudent( mStudent );
            }
         }
      }
      else if ( action == "Save" ) {
         if ( mStudent != null ) {
            saveStudent( mStudent );
         }
      }
      else if ( action == "Clear" ) {
         clear();
      }
      else if ( action == "Exit" ) {
         if ( mStudent != null ) {
            saveStudent( mStudent );
         }

         mMain.exit();
      }
   }

   /**
    * clear()
    *
    * Called when the Clear button is clicked. Clears all of
    * the text fields by setting the contents to the empty
    * string.
    * After clear() returns, no student information is being
    * edited or displayed.
    */
   private void clear() {
      mSearchText.setText( "" );

      for ( int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++ ) {
         mHomeworkText[i].setText( "" );
      }
      for ( int k = 0; k <= CourseConstants.NUM_EXAMS - 1; k++ ) {
         mExamText[k].setText( "" );
      }

      mStudent = null;
   }

   /**
    * displayStudent()
    *
    * Displays the homework and exam scores for a student in
    * the mHomeworkText and mExamText text fields.
    */
   private void displayStudent(Student pStudent) {

      for ( int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++ ) {
         int hw = pStudent.getHomework( i );
         String hwstr = Integer.toString( hw );
         mHomeworkText[i].setText( hwstr );
      }
      for ( int k = 0; k <= CourseConstants.NUM_EXAMS - 1; k++ ) {
         int exam = pStudent.getExam( k );
         String examstr = Integer.toString( exam );
         mExamText[k].setText( examstr );
      }

   }

   /**
    * messageBox()
    *
    * Displays a message box containing some text.
    */
   public void messageBox(String pMessage) {
      JOptionPane.showMessageDialog( this, pMessage, "Message",
            JOptionPane.PLAIN_MESSAGE );
   }

   /**
    * saveStudent()
    *
    * Retrieves the homework and exam scores for pStudent
    * from the text fields and writes the results to the
    * Student record
    * in the Roster.
    */
   private void saveStudent(Student pStudent) {
      for ( int i = 0; i <= CourseConstants.NUM_HOMEWORKS - 1; i++ ) {
         String hwstr = mHomeworkText[i].getText();
         int hw = Integer.parseInt( hwstr );
         pStudent.setHomework( i, hw );
      }
      for ( int k = 0; k <= CourseConstants.NUM_EXAMS - 1; k++ ) {
         String examstr = mExamText[k].getText();
         int exam = Integer.parseInt( examstr );
         pStudent.setExam( k, exam );
      }

   }

}