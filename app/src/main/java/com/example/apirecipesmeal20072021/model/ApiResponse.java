package com.example.apirecipesmeal20072021.model;

public class ApiResponse<T> {
    //Dạng ngắn gọn, không cần dùng phần mềm chuyển đổi
    //Object khi gọi detail.php
    //phải để 2 biến đúng tên message và data như api
    public String message;
    public T data;
}
