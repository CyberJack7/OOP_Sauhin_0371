package ru.etu.components;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class eventTableModel extends AbstractTableModel {
    private ArrayList<Event> events = new ArrayList<>();

    public eventTableModel(ArrayList<Event> events){
        this.events = events;
    }

    @Override
    public int getRowCount() {
        return events.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "Название";
            case 1: return "Тематика";
            case 2: return "Дата и время";
            case 3: return "Место";
            case 4: return "Тип мероприятия";
            case 5: return "Жанр";
            case 6: return "Описание";
            case 7: return "Программа";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4 || columnIndex == 5) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Event event = events.get(rowIndex);
        switch (columnIndex){
            case 0: return event.getEventName();
            case 1: return event.getSubject();
            case 2: return event.getDate();
            case 3: return event.getPlace();
            case 4: return event.getEventTypeId();
            case 5: return event.getGenreId();
            case 6: return event.getDescription();
            case 7: return event.getProgram();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Event event = events.get(rowIndex);
        switch (columnIndex){
            case 0:
                event.setEventName((String) aValue);
                break;
            case 1:
                event.setSubject((String) aValue);
                break;
            case 2:
                event.setDate((String) aValue);
                break;
            case 3:
                event.setPlace((String) aValue);
                break;
            case 4:
                event.setEventTypeId((Integer) aValue);
                break;
            case 5:
                event.setGenreId((Integer) aValue);
                break;
            case 6:
                event.setDescription((String) aValue);
                break;
            case 7:
                event.setProgram((String) aValue);
                break;
        }
    }
}