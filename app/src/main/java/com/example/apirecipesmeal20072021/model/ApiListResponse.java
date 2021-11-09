package com.example.apirecipesmeal20072021.model;

import java.util.List;

public class ApiListResponse<T> {
    //Dạng ngắn gọn, không cần dùng phần mềm chuyển đổi
    //Object khi gọi meals.php
    //phải để 2 biến đúng tên message và data như api
    public String message;
    public List<T> data;
}
