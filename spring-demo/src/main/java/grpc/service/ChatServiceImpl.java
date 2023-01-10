package grpc.service;

import io.grpc.stub.StreamObserver;
import proto.chat.*;

import java.util.ArrayList;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    ArrayList<ChatMessage> chatMessages = new ArrayList<>();

    @Override
    public void sendMsg(MessageRequest request, StreamObserver<Empty> responseObserver) {
        System.out.println("You are in the SEND method");

        ChatMessage chatMessage = request.getChatMessage();
        chatMessages.add(chatMessage);
        Empty emptyResponse = Empty.newBuilder().getDefaultInstanceForType();

        responseObserver.onNext(emptyResponse);// send the response
        responseObserver.onCompleted();// complete the execution
    }

    @Override
    public void receiveMsg(Empty request, StreamObserver<ChatMessage> responseObserver) {
        System.out.println("You are in the RECEIVE method");
        for(ChatMessage chatMessage : chatMessages){
            String result = "from: " + chatMessage.getFrom() + " to: " + chatMessage.getTo() +
                    " msg: " + chatMessage.getMsg() + " time: " + chatMessage.getTime();
            System.out.println(result);
            responseObserver.onNext(chatMessage);// send the response
        }
        responseObserver.onCompleted();// complete the execution
    }

}
