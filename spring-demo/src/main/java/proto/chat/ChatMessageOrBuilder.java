// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package proto.chat;

public interface ChatMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.chat.ChatMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string from = 1;</code>
   * @return The from.
   */
  java.lang.String getFrom();
  /**
   * <code>string from = 1;</code>
   * @return The bytes for from.
   */
  com.google.protobuf.ByteString
      getFromBytes();

  /**
   * <code>string msg = 2;</code>
   * @return The msg.
   */
  java.lang.String getMsg();
  /**
   * <code>string msg = 2;</code>
   * @return The bytes for msg.
   */
  com.google.protobuf.ByteString
      getMsgBytes();

  /**
   * <code>string time = 3;</code>
   * @return The time.
   */
  java.lang.String getTime();
  /**
   * <code>string time = 3;</code>
   * @return The bytes for time.
   */
  com.google.protobuf.ByteString
      getTimeBytes();
}
