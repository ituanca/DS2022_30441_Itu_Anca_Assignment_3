package grpc.service;

import io.grpc.stub.StreamObserver;
import proto.chat.*;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {
    @Override
    public void sendMsg(MessageRequest request, StreamObserver<Empty> responseObserver) {
        System.out.println("You are in the greet method or the greet service");

        // we get the object from the request (as defined in the proto file)
        ChatMessage chatMessage = request.getChatMessage();
        String result = "from: " + chatMessage.getFrom() + " msg: " + chatMessage.getMsg() + " time: " + chatMessage.getTime();
        System.out.println(result);
        // build our response where the type should be Empty
        Empty emptyResponse = Empty.newBuilder().getDefaultInstanceForType();

        responseObserver.onNext(emptyResponse);// send the response
        responseObserver.onCompleted();// complete the execution
    }

    @Override
    public void receiveMsg(Empty request, StreamObserver<ChatMessage> responseObserver) {

    }

}
