//Q1-- Q4:
import java.util.*;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private float credits;
    private int[] studentIds;
    private int currentStudentNum = 0;

    //getters and setters

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId > 0) {
            this.courseId = courseId;
        } else {
            System.out.println("course ID can only be positive integer");
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName.length() <= 60 && courseName.length() >= 10) {
            this.courseName = courseName;
        } else {
            System.out.println("course name can be only with minimum length 10 and maximum 60");
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity <= 100 && maxCapacity >= 10) {
            this.maxCapacity = maxCapacity;
        } else {
            System.out.println("max capacity can not be less than 10 greater than 100");
        }
    }


    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        int length = String.valueOf(professorId).length();
        if (length == 6) {
            this.professorId = professorId;
        } else {
            System.out.println("professor ID should be 6 digit integer");
        }

    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        if (credits > 0.0 && credits < 10.0) {
            this.credits = credits;
        } else {
            System.out.println("credits should be single digit");
        }
    }

    //constructors

    public Course(int courseId) {
        this.courseId = courseId;
    }

    public Course(int courseId, int professorId) {
        this(courseId);
        this.professorId = professorId;
    }

    public Course(int courseId, int professorId, float credits) {
        this(courseId, professorId);
        this.credits = credits;
    }


    // function register student
    public void regiterStudent(int studentId) {
        studentIds[currentStudentNum++] = studentId;
    }

    public int[] removeDuplicates(int[] studentIds) {
        Set<Integer> hs = new HashSet<>();
        if (studentIds.length >= maxCapacity) {
            for (int i = 0; i < studentIds.length; i++) {
                hs.add(studentIds[i]);
            }
        }
        int[] uniqueIds = new int[hs.size()];
        int j = 0;
        for (Integer n : hs) {
            uniqueIds[j++] = n;
        }
        return uniqueIds;
    }

    public int groupsOfStudents(int[] studentIds) {
        int output = 0;
        for (int i = 0; i < studentIds.length; i++) {
            for (int j = i + 1; j < studentIds.length; j++) {
                if ((studentIds[i] + studentIds[j]) % 2 == 0) {
                    output++;
                }
            }
        }
        return output;
    }

-----------------------------------------------------------------------------------------------------------------------

//Q5.
//The count-and-say sequence is a sequence of integers with the first five terms as following:
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221

public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder next = cur;
        int count;
        char say;
        for (int i = 0; i < n; i++) {
            next = new StringBuilder();
            count = 1;
            say = cur.charAt(0);
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != say) {
                    next.append(count).append(say);
                    count = 1;
                    say = cur.charAt(j);
                } else count++;
            }
            next.append(count).append(say);
        }
        return next.toString();
}

-----------------------------------------------------------------------------------------------------------------------

//Q6. Given an input string , reverse the string word by word.
//Example:
//Input : “the sky is blue”
//Output : “blue is sky the”
//Assumptions:
//A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces.
//The words are always separated by a single space.

    public String reverseWords(String s) {
        if(s == null){return null; }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() -1 ; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                continue;
            }else{
                int end = i;
                while(i>= 0 && s.charAt(i) != ' ') i --;
                String word = s.substring(i+1, end+1);
                sb.append(word).append(" ");
            }

        }
        return sb.toString().trim();

    }
-----------------------------------------------------------------------------------------------------------------------
//Q7.
//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[m*n];

        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = m-1;

        int index = 0;

        while(true){
            for (int i = left; i <=right ; i++) {
                res[index++] = matrix[top][i];
            }
            top++;
            if (bottom < top || left > right) {
                break;
            }

            for (int j = top; j <= bottom; j++) {
                res[index++] = matrix[j][right];
            }
            right--;
            if(left > right ||  bottom < top){
                break;
            }

            for(int i = right; i >= left; i--){
                res[index++] = matrix[bottom][i];
            }
            bottom --;
            if (bottom < top || left > right) {
                break;
            }
            for (int j = bottom; j >= top; j--) {
                res[index++] = matrix[j][left];
            }
            left++;
            if(left > right || bottom < top){
                break;
            }
        }
        return res;            
    }
}

-----------------------------------------------------------------------------------------------------------------------
//Q8.
//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
public String convert(String s, int numRows){
        char[] c = s.toCharArray();
        int n = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i <sb.length ; i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while(i<n){
            for(int j = 0; j< numRows && i<n; j++){
                sb[j].append(c[i++]);
            }
            for (int j = numRows-2 ; j >=1 && i<n; j--) {
                sb[j].append(c[i++]);
            }
        }
        for (int idx = 1; idx < sb.length ; idx++) {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }

-----------------------------------------------------------------------------------------------------------------------

Q9. Explain Encapsulation with an example. (Write at least 30-40 words).
Encapsulation is wrapping data inside and keeping them private but only provides public methods to access.
For example, if we have a class to store personal information of our professors. We set professors' names, phone number, age
to be private.We use setName(), setPhoneNumber(), setAge() methods to set up and control how to manage dataAnd then we provide 
getName(), getPhoneNumber(), getAge() methods to get the information outside the class.

-----------------------------------------------------------------------------------------------------------------------

Q10. What is the difference between Encapsulation and Abstraction
Encapsulation is a way to protect object from tempering. It sets all the states private so it can only be accessed inside the class.
Abstraction is 



