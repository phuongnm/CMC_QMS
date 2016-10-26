package com.cmc.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity(table = "issues")
public class Issues {

    @Column(name = "tracker_id")
    private int trackerId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "created_on")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createdOn;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date startDate;

    @Column(name = "done_ratio")
    private int doneRatio;

    @Column(name = "estimated_hour")
    
    private String estimatedHour;

    /**
     */
    @ManyToOne
    private Projects projecId;

    /**
     */
    @ManyToOne
    private Users assignedToId;
}
