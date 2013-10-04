/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.person;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author nkululekophakela
 */
@Entity
@Table(name = "title")
public class Title implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="title_id")
    private int titleId;
    @Column(name="title")
    private String title;

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Title{" + "titleId=" + titleId + ", title=" + title + '}';
    }
}
