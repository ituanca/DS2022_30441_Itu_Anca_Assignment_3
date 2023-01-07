package grpc.service;

import io.grpc.stub.StreamObserver;
import proto.chat.*;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    ChatMessage chatMessage;

    @Override
    public void sendMsg(MessageRequest request, StreamObserver<Empty> responseObserver) {
        System.out.println("You are in the SEND method or the greet service");

        chatMessage = request.getChatMessage();
        String result = "from: " + chatMessage.getFrom() + " msg: " + chatMessage.getMsg() + " time: " + chatMessage.getTime();
        System.out.println(result);

        Empty emptyResponse = Empty.newBuilder().getDefaultInstanceForType();

        responseObserver.onNext(emptyResponse);// send the response
        responseObserver.onCompleted();// complete the execution
    }

    @Override
    public void receiveMsg(Empty request, StreamObserver<ChatMessage> responseObserver) {
        System.out.println("You are in the RECEIVE method or the chat service");
        if(chatMessage != null){
            String result = "from: " + chatMessage.getFrom() + " msg: " + chatMessage.getMsg() + " time: " + chatMessage.getTime();
            System.out.println(result);
            responseObserver.onNext(chatMessage);// send the response
            responseObserver.onCompleted();// complete the execution
        }
    }

}
