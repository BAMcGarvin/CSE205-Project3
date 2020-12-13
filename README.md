# CSE205-Project3
Gradebook Reader/Writer

Your program shall meet these requirements:

1. Student information for students in a course is stored in a text file named gradebook.txt. There is one student record per line, where the format of a student record is:
last-name first-name hw1 hw2 hw3 hw4 exam1 exam2       where:

last-name = The student's last name. A contiguous string of characters, with no spaces.
first-name = The student's first name. A contiguous string of characters, with no spaces.
hw1-hw4 = The student's scores on four homework assignments, may be zeros.
exam1-exam2 = The student's scores on two exams, may be zeros.\

Here is an example gradebook.txt file:
Sample gradebook.txt
Simpson Lisa 25 25 25 25 100 100
Flintstone Fred 15 17 22 18 80 60
Jetson George 20 21 22 23 70 83
Explosion Nathan 5 4 3 2 1 0
Muntz Nelson 20 15 10 5 60 70
Terwilliger Robert 23 21 19 17 80 90
Flanders Ned 12 14 17 23 85 95
Bouvier Selma 16 16 16 16 16 16
Spuckler Cletus 1 2 3 4 5 6
Wiggum Clancy 6 5 4 3 2 1
Skinner Seymour 19 23 21 24 78 83

2. When the program starts, it shall read the contents of gradebook.txt and sort the list of students into ascending order.
3. When the program starts, if the gradebook.txt file cannot be read, the program shall display a message dialog box telling the user that gradebook.txt could not be opened for reading, and when the user clicks the OK button to close the dialog, the program shall terminate.
4. The program shall implement a GUI which permits the user to interact with the gradebook. Watch the Project 3 video lecture for a demonstration of how the GUI works.
5. When the enters a student's last name in the search text field and clicks the Search button, the homework and exam information for the student shall be displayed in the text fields.
6. When the user clicks the Search button and the search text field is empty an error message dialog shall be displayed.
7. When the enters a last name in the search text field and clicks the Search button, if the student is not found because the last name was entered incorrectly an error message dialog shall be displayed.
8. When the user is editing the information for a student and clicks the Save button, the student record shall be updated (these changes will be written to gradebook.txt when the program exits).
9. When no student record is being edited (the homework and exam text fields are empty) and the user clicks the Save button, nothing shall happen.
10. When the user is editing the information for a student and clicks the Clear button, the homework and exam text fields shall be set to empty and the student record shall not be updated.
11. When the user is editing the information for a student and clicks the Exit button, the student record shall be saved before exiting.
12. Whether the user is editing student information or not, when the Exit button is clicked the student records shall be written to gradebook.txt and the program shall terminate.
