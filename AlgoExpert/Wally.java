import javax.annotation.processing.Filer;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Lost a lot of time because I had no idea how to read files :(. Googled for a while and figured out how to do it. The answer is 363.73 units away.
 */
public class Wally {
// calculate the Eclean distance given the coordinates
    public static double Euclean(int x1, int y1, int x2, int y2){
        int x = x1-x2;
        int y = y1-y2;
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    public static void main(String[] args) throws FileNotFoundException {
        double maxEuclean = 0;
        BufferedReader reader = new BufferedReader(new FileReader("/Users/USUARIO/IdeaProjects/AlgoExpert/wally"));
        try {
            // Store and read lines in the document
            String line;
            // whenever you see this, it means it will read the line, and if declared again it will read the NEXT line
            line = reader.readLine();

            // separate_String will be used to separate the string by whitespaces in the txt file.
            String[] separate_String = line.split(" ", -1);

            // store starting positions
            int startX = Integer.parseInt(separate_String[0]);
            int startY = Integer.parseInt(separate_String[1]);
            char curr_direction = separate_String[2].charAt(0);
            line = reader.readLine();

            separate_String = line.split(" ", -1);
            int NumObstacles = Integer.parseInt(separate_String[0]);
            int NumCommands = Integer.parseInt(separate_String[1]);
            line = reader.readLine();


            // I will store the obstacle coordinates in here for constant lookup
            Map<Integer, Integer> obstacles = new HashMap<>();

            // loop through the obstacle coordinates in the file and store them
            for (int i = 0; i < NumObstacles; i++) {
                // store the obstacles that are on the input file
                String[] arr = line.split(" ",-1);
                obstacles.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
                line = reader.readLine();
            }
            // store the directions in THIS order. if we move right or left should be alright
            char[] direction_list = {'W', 'N', 'E', 'S'};

            int index = 0;
            // Find the index of the starting curr_direction in this loop
            for(char x: direction_list) {
                if(x == curr_direction)break;
                index++;
            }

            for (int i = 0; i < NumCommands; i++) {
                // get the first character in the line
                char command = line.charAt(0);
                // if true, then it must be R or L
                if (command != 'M') {
                    if (command == 'R') {
                        // check if index out of bounds
                        if(index == 3)
                            index = 0;
                        else index++;
                    } else {
                        // check if index out of bounds
                        if(index == 0)
                             index = 3;
                        else index--;
                    }
                    // reassign the current direction
                    curr_direction = direction_list[index];
                } else {
                    // We must have an "M" at the first character
                    separate_String = line.split(" ", -1);
                    int steps = Integer.parseInt(separate_String[1]);
                    // start walking
                    for (int j = 0; j < steps; j++) {
                        // if we enter an point where there is an obstacle, take a step back and go to the next command.
                        if (obstacles.containsKey(startX)) {
                            if (obstacles.get(startX) == startY) {
                                // take a step back, depends on where you came from. Then go to the next command
                                if(curr_direction == 'W') startX++;
                                else if(curr_direction == 'N') startY -=1;
                                else if(curr_direction == 'E')  startX--;
                                else startY++;
                                break;
                            }
                        }
                        // self-explanatory haha
                        if (curr_direction == 'W') {
                            startX -= 1;
                        } else if (curr_direction == 'N') {
                            startY += 1;
                        } else if (curr_direction == 'E') {
                            startX += 1;
                        } else startY -= 1;
                    }
                    // find the euclean and if its bigger than the current, change it.
                    double temp = Euclean(0, 0, startX, startY);
                    maxEuclean = Math.max(temp, maxEuclean);
                }
                line = reader.readLine();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
       System.out.print(maxEuclean);
     }

    }


