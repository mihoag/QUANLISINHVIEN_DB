package service;

import java.util.ArrayList;

public interface DAOinterface<T> {
    public void them(T t);
    public void xoa(T t);
    public ArrayList<T> selectAll();
    public void sua(T t);
    boolean checkTontai(String ma);
}
