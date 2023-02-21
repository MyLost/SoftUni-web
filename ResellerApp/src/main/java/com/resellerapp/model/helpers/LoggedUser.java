package com.resellerapp.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoggedUser {
    private Long id;

    public boolean isEmpty() {
        return this.id == null;
    }

    public void clearUser() {
        this.id = null;
    }
}

