package com.mm_cinema.common_library.constants;

public final class ApiConstant {
    public static final String WAREHOUSE_URL = "/backoffice/warehouses";
    public static final String STOCK_HISTORY_URL = "/backoffice/stocks/histories";
    
    public static final Integer SUCCESS_CODE = 200;
    public static final String OK = "Ok";
    
    public static final Integer CREATED_CODE = 201;
    public static final String CREATED = "Created";
    
    public static final Integer NO_CONTENT_CODE = 204;
    public static final String NO_CONTENT = "No content";
    
    public static final Integer BAD_REQUEST_CODE = 400;
    public static final String BAD_REQUEST = "Bad request";
    
    public static final Integer UNAUTHORIZED_CODE = 401;
    public static final String UNAUTHORIZED = "Unauthorized";
    
    public static final Integer FORBIDDEN_CODE = 403;
    public static final String FORBIDDEN = "Forbidden";
    public static final String ACCESS_DENIED = "ACCESS_DENIED";
    
    public static final Integer NOT_FOUND_CODE = 404;
    public static final String NOT_FOUND = "Not found";

    public static final Integer INTERNAL_ERROR_CODE = 500;
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
    

    private ApiConstant() {
        //Add constructor
    }
}
