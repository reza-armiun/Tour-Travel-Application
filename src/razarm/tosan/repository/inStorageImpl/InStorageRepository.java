package razarm.tosan.repository.inStorageImpl;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.accommodation.AccommodationOrderData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface InStorageRepository<T extends BaseEntityData> {


    default  void writeObject(T t) {
        try {
            ObjectOutputStream oos = getObjectOutputStream();
            oos.writeObject(t);
            oos.flush();
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
    }
    default  List<T> readObject() {
        try {
            ObjectInputStream reader = getObjectInputStream();
            List<T> orderDataList = new ArrayList<>();
            while (true ) {
                try {
                    T obj = (T) reader.readObject();
                    orderDataList.add(obj);
                } catch (Exception ex) {
                    orderDataList.forEach(this::writeObject);
                    return orderDataList;
                }
            }
        } catch (Exception e) {
            System.out.println("Problem serializing: " + e);
        }
        return Collections.emptyList();
    }

    default void updateObject(T updateObj) {
        var objectList = readObject();
        objectList.stream().map(obj -> {
            if(obj.getId().equals(updateObj.getId())) {
                return  updateObj;
            }
            return obj;
        }).peek(this::writeObject);
    }


    default void deleteObject(String id) {
        var objectList = readObject();
        var li = objectList.stream().filter(t -> !t.getId().equals(id)).peek(this::writeObject);
    }


    ObjectOutputStream getObjectOutputStream();
    ObjectInputStream getObjectInputStream();
}
