package DataAccessObject;

import java.util.ArrayList;

//Tạo ra 1 interface DataAccessObjectInterface để tạo ra 1 nơi có thể thao tác với dữ liệu 1 cách dễ dàng hơn 
public interface DataAccessObjectInterface<T> {/*T là 1 đối tượng ta truyền vào tức là mõi đối tượng mà ta
truyền vào là 1 table của database*/

public int Insert(T t);
public int Uppdate(T t);
public int Delete(T t);

public ArrayList<T> selecALL();

public T selectById(T t);

public ArrayList<T> selecByCondition(String condition);

}
