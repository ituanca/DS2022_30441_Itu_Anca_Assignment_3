// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package proto.chat;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_chat_ChatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_chat_ChatMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_chat_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_chat_Empty_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_chat_MessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_chat_MessageRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nchat.proto\022\nproto.chat\"6\n\013ChatMessage\022" +
      "\014\n\004from\030\001 \001(\t\022\013\n\003msg\030\002 \001(\t\022\014\n\004time\030\003 \001(\t" +
      "\"\007\n\005Empty\">\n\016MessageRequest\022,\n\013chatMessa" +
      "ge\030\001 \001(\0132\027.proto.chat.ChatMessage2\207\001\n\013Ch" +
      "atService\022:\n\007sendMsg\022\032.proto.chat.Messag" +
      "eRequest\032\021.proto.chat.Empty\"\000\022<\n\nreceive" +
      "Msg\022\021.proto.chat.Empty\032\027.proto.chat.Chat" +
      "Message\"\0000\001B\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_proto_chat_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_chat_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_chat_ChatMessage_descriptor,
        new java.lang.String[] { "From", "Msg", "Time", });
    internal_static_proto_chat_Empty_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_chat_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_chat_Empty_descriptor,
        new java.lang.String[] { });
    internal_static_proto_chat_MessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_proto_chat_MessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_chat_MessageRequest_descriptor,
        new java.lang.String[] { "ChatMessage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
