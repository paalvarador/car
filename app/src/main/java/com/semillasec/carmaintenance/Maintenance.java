package com.semillasec.carmaintenance;

import java.util.Date;

/**
 * Created by root on 26/06/15.
 */
public class Maintenance {
    // private variables
    int _id;
    String _name;
    String _date;
    String _description;
    int _miliage;
    int _miliage_next;

    // Empty constructor
    public Maintenance() {
    }

    // Constructor
    public Maintenance(int _id, String _name, String _date, String description, int _miliage, int _miliage_next) {
        this._id = _id;
        this._name = _name;
        this._date = _date;
        this._description = description;
        this._miliage = _miliage;
        this._miliage_next = _miliage_next;
    }

    // Constructor
    public Maintenance(String _name, String _date, String description, int _miliage, int _miliage_next) {
        this._name = _name;
        this._date = _date;
        this._description = description;
        this._miliage = _miliage;
        this._miliage_next = _miliage_next;
    }

    // getting id
    public int get_id() {
        return _id;
    }

    // getting name
    public String get_name() {
        return _name;
    }

    // getting date
    public String get_date() {
        return _date;
    }

    // getting description
    public String getDescription() {
        return _description;
    }

    // getting miliage
    public int get_miliage() {
        return _miliage;
    }

    // getting miliage_next
    public int get_miliage_next() {
        return _miliage_next;
    }

    // setting id
    public void set_id(int _id) {
        this._id = _id;
    }

    // setting name
    public void set_name(String _name) {
        this._name = _name;
    }

    // setting date
    public void set_date(String _date) {
        this._date = _date;
    }

    // setting miliage
    public void set_miliage(int _miliage) {
        this._miliage = _miliage;
    }

    // setting description
    public void setDescription(String _description) {
        this._description = _description;
    }

    // setting miliage_next
    public void set_miliage_next(int _miliage_next) {
        this._miliage_next = _miliage_next;
    }
}
