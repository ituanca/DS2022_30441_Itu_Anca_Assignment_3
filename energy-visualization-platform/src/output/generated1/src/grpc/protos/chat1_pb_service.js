// package: proto.chat
// file: src/grpc/protos/chat1.proto

var src_grpc_protos_chat1_pb = require("../../../src/grpc/protos/chat1_pb");
var grpc = require("@improbable-eng/grpc-web").grpc;

var ChatService = (function () {
  function ChatService() {}
  ChatService.serviceName = "proto.chat.ChatService";
  return ChatService;
}());

ChatService.sendMsg = {
  methodName: "sendMsg",
  service: ChatService,
  requestStream: false,
  responseStream: false,
  requestType: src_grpc_protos_chat1_pb.MessageRequest,
  responseType: src_grpc_protos_chat1_pb.MessageResponse
};

ChatService.receiveMsg = {
  methodName: "receiveMsg",
  service: ChatService,
  requestStream: false,
  responseStream: false,
  requestType: src_grpc_protos_chat1_pb.Empty,
  responseType: src_grpc_protos_chat1_pb.ChatMessage
};

exports.ChatService = ChatService;

function ChatServiceClient(serviceHost, options) {
  this.serviceHost = serviceHost;
  this.options = options || {};
}

ChatServiceClient.prototype.sendMsg = function sendMsg(requestMessage, metadata, callback) {
  if (arguments.length === 2) {
    callback = arguments[1];
  }
  var client = grpc.unary(ChatService.sendMsg, {
    request: requestMessage,
    host: this.serviceHost,
    metadata: metadata,
    transport: this.options.transport,
    debug: this.options.debug,
    onEnd: function (response) {
      if (callback) {
        if (response.status !== grpc.Code.OK) {
          var err = new Error(response.statusMessage);
          err.code = response.status;
          err.metadata = response.trailers;
          callback(err, null);
        } else {
          callback(null, response.message);
        }
      }
    }
  });
  return {
    cancel: function () {
      callback = null;
      client.close();
    }
  };
};

ChatServiceClient.prototype.receiveMsg = function receiveMsg(requestMessage, metadata, callback) {
  if (arguments.length === 2) {
    callback = arguments[1];
  }
  var client = grpc.unary(ChatService.receiveMsg, {
    request: requestMessage,
    host: this.serviceHost,
    metadata: metadata,
    transport: this.options.transport,
    debug: this.options.debug,
    onEnd: function (response) {
      if (callback) {
        if (response.status !== grpc.Code.OK) {
          var err = new Error(response.statusMessage);
          err.code = response.status;
          err.metadata = response.trailers;
          callback(err, null);
        } else {
          callback(null, response.message);
        }
      }
    }
  });
  return {
    cancel: function () {
      callback = null;
      client.close();
    }
  };
};

exports.ChatServiceClient = ChatServiceClient;

