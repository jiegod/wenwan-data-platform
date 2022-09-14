package com.wenwan.model.user;

import com.wenwan.model.request.ListQuery;
import lombok.Data;

@Data
public class UserVo extends ListQuery {
    private String username;
    private String password;
}
