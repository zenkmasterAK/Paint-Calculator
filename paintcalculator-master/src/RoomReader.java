
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomReader {

    public List<Paintable> readRoomFile(String fileName) {
        List<Paintable> roomList = new ArrayList<Paintable>();
        ObjectInputStream ois = null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);

            Object obj = null;
            // Allow the EOF Exception to happen
            try {
                while ((obj = ois.readObject()) != null) {
                    Paintable room = (Paintable) obj;
                    roomList.add(room);
                }
            } catch (EOFException e) {
                // Do nothing, we expect this to happen
            }

            System.out.println("Rooms successfully read");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomList;
    }

    
}
