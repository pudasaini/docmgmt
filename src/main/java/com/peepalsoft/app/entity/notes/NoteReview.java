package com.peepalsoft.app.entity.notes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity @Table()
@Getter @Setter
public class NoteReview extends CoreNoteBaseEntity {
    private int refByNoteId;
    private int likedByCount;
    private int dislikedByCount;
    private int viewedCount;
    private int rating;

}
