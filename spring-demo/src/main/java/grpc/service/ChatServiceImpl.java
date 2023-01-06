package grpc.service;

import io.grpc.stub.StreamObserver;
import proto.chat.*;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    @Override
    public void sendMsg(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        System.out.println("You are in the greet method or the greet service");

        // we get the greeting object from the request (as defined in the proto file)
        ChatMessage chatMessage = request.getChatMessage();
        String result = "from: " + chatMessage.getFrom() + " msg: " + chatMessage.getMsg() + " time: " + chatMessage.getTime();

        // build our response where the type should be GreetResponse
        MessageResponse response = MessageResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);// send the response
        responseObserver.onCompleted();// complete the execution
    }

    @Override
    public void receiveMsg(Empty request, StreamObserver<ChatMessage> responseObserver) {
        super.receiveMsg(request, responseObserver);
    }

}
