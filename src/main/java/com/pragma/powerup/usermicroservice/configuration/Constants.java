package com.pragma.powerup.usermicroservice.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String MOVIE_ALREADY_EXISTS_MESSAGE = "A movie already exists with the name provided";
    public static final String MULTIPLEX_CREATED_MESSAGE = "Multiplex created succesfully";
    public static final String MULTIPLEX_ALREADY_EXISTS_MESSAGE = "A multiplex already exists with the name provided";
    public static final String NO_THEATRES_ENOUGH_MESSAGE = "Hay muy pocas o demasiadas salas para el multiplex";
    public static final Long ADMIN_ROLE_ID = 1L;
    public static final Long OWNER_ROLE_ID = 2L;
    public static final String MULTIPLEX_POINTS_UPDATE = "A multiplex points update usefull";
    public static final String RESPONSE_MESSAGE_KEY = "message";
    public static final String RESPONSE_ERROR_MESSAGE_KEY = "error";
    public static final String WRONG_CREDENTIALS_MESSAGE = "Wrong credential";

    public static final String NO_ALLOWED_USER_MESSAGE = "The user of token is no authorized";
    public static final String NO_MULTIPLEX_FOUND_MESSAGE = "The Multiplex is not found";
    public static final String NO_MOVIE_FOUND_MESSAGE = "The Movie is not found";
    public static final String NO_SHOW_FOUND_MESSAGE = "The Show for the idMovie and idMultiplex is not found";
    public static final String NO_THEATER_FOUND_MESSAGE = "The theater is not found with idTheater provided";
    public static final String NO_CREATE_SHOW_MESSAGE = "A Show already exists with the day and schedule provided";
    public static final String NO_SHOW_EXIST_MESSAGE = "The show no exist with scheduler provided";
    public static final String NO_INVOICE_EXIST_MESSAGE = "The invoice no exist with idInvoice provided";
    public static final String CLIENT_CANNOT_UPDATE_RAITING_MESSAGE = "The client cannot update qualification of move because already updated or does not belong to client or the invoice is not paid";
    public static final String SELECT_CHAIR_RESERVED_MESSAGE = "A chair select for show alrady stay reserved";
    public static final String STATE_PROGRESS = "EN PROCESO";
    public static final String STATE_COMPLETE = "PAGADO";
    public static final String PHONE_LENGHT_MESSAGE = "The lenght of Phone is over 13";
    public static final String RAITING_MOVIE_UPDATED_MESSAGE = "The qualification of movie update successfully";
    public static final String NO_DATA_FOUND_MESSAGE = "No data found for the requested petition";
    public static final String PLATE_CREATED_MESSAGE = "Plate created successfully";
    public static final String ORDER_CREATED_MESSAGE = "Order created successfully, awaits the call for delivery";
    public static final String NO_CATEGORY_FOUND_MESSAGE = "No category found for the name send with requested petition";
    public static final String NO_RESTAURANT_FOUND_MESSAGE = "No restaurant found for the nit send with requested petition";
    public static final String NO_PLATE_FOUND_MESSAGE = "No plate found for the idPlate send with requested petition";
    public static final String OWNER_NO_ALLOWED_CREATION_MESSAGE = "The owner do transaction no have permisse for create plate in the restaurant with send in requested petition";
    public static final String PLATE_UPDATED_MESSAGE = "Plate update successfully";
    public static final String PLATE_NO_BELONG_RESTAURANT_MESSAGE = "The plate does not belong to the restaurant nit sent with requested petition";
    public static final String NO_ALLOWED_OWNER_UPDATE_PLATE_MESSAGE = "The owner who is trying to update the plate, does not have permissions to update that plate.";
    public static final String ILLEGAL_ARGUMENT_SIZE_PAGE_MESSAGE = "Page size must not be less than one";
    public static final String ILLEGAL_ARGUMENT_INDEX_PAGE_MESSAGE = "Page index must not be less than zero";
    public static final String ILLEGAL_SIZE_OF_PLATES_IN_ORDEN_MESSAGE = "TThe dishes with their quantities entered in the order have a problem, please try again with the correct number of dishes and their corresponding quantity.";
    public static final String NON_RESTAURANT_PLATE_MESSAGE = "Some of the plates requered do not belong to the restaurant with nit requered.";

    public static final String CLIENTE_HAS_ACTIVE_ORDER_MESSAGE = "The client no can make this order, beacause has a other order active.";
    public static final String ROLES = "roles";
    public static final String SWAGGER_TITLE_MESSAGE = "User API Pragma Power Up";
    public static final String SWAGGER_DESCRIPTION_MESSAGE = "User microservice";
    public static final String SWAGGER_VERSION_MESSAGE = "1.0.0";
    public static final String SWAGGER_LICENSE_NAME_MESSAGE = "Apache 2.0";
    public static final String SWAGGER_LICENSE_URL_MESSAGE = "http://springdoc.org";
    public static final String SWAGGER_TERMS_OF_SERVICE_MESSAGE = "http://swagger.io/terms/";


    public static final String IDUSER = "idUser";

}
