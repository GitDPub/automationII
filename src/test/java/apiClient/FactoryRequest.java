package apiClient;

public class FactoryRequest {

    public static IRequest make (String type){
        IRequest request;
        switch (type.toLowerCase()){

            case "get":
                request=new RequestGET();
                break;

            case "post":
                request=new RequestPOST();
                break;

            default:
                request=new RequestGET();
                break;

        }
        return request;
    }
}
