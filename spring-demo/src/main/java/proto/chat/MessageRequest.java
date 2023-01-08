// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package proto.chat;

/**
 * Protobuf type {@code proto.chat.MessageRequest}
 */
public final class MessageRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.chat.MessageRequest)
    MessageRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageRequest.newBuilder() to construct.
  private MessageRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proto.chat.Chat.internal_static_proto_chat_MessageRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proto.chat.Chat.internal_static_proto_chat_MessageRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proto.chat.MessageRequest.class, proto.chat.MessageRequest.Builder.class);
  }

  public static final int CHATMESSAGE_FIELD_NUMBER = 1;
  private proto.chat.ChatMessage chatMessage_;
  /**
   * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
   * @return Whether the chatMessage field is set.
   */
  @java.lang.Override
  public boolean hasChatMessage() {
    return chatMessage_ != null;
  }
  /**
   * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
   * @return The chatMessage.
   */
  @java.lang.Override
  public proto.chat.ChatMessage getChatMessage() {
    return chatMessage_ == null ? proto.chat.ChatMessage.getDefaultInstance() : chatMessage_;
  }
  /**
   * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
   */
  @java.lang.Override
  public proto.chat.ChatMessageOrBuilder getChatMessageOrBuilder() {
    return chatMessage_ == null ? proto.chat.ChatMessage.getDefaultInstance() : chatMessage_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (chatMessage_ != null) {
      output.writeMessage(1, getChatMessage());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (chatMessage_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getChatMessage());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof proto.chat.MessageRequest)) {
      return super.equals(obj);
    }
    proto.chat.MessageRequest other = (proto.chat.MessageRequest) obj;

    if (hasChatMessage() != other.hasChatMessage()) return false;
    if (hasChatMessage()) {
      if (!getChatMessage()
          .equals(other.getChatMessage())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasChatMessage()) {
      hash = (37 * hash) + CHATMESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getChatMessage().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static proto.chat.MessageRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.chat.MessageRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.chat.MessageRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.chat.MessageRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.chat.MessageRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proto.chat.MessageRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proto.chat.MessageRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proto.chat.MessageRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.chat.MessageRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static proto.chat.MessageRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proto.chat.MessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proto.chat.MessageRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(proto.chat.MessageRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.chat.MessageRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.chat.MessageRequest)
      proto.chat.MessageRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.chat.Chat.internal_static_proto_chat_MessageRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.chat.Chat.internal_static_proto_chat_MessageRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.chat.MessageRequest.class, proto.chat.MessageRequest.Builder.class);
    }

    // Construct using proto.chat.MessageRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      chatMessage_ = null;
      if (chatMessageBuilder_ != null) {
        chatMessageBuilder_.dispose();
        chatMessageBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proto.chat.Chat.internal_static_proto_chat_MessageRequest_descriptor;
    }

    @java.lang.Override
    public proto.chat.MessageRequest getDefaultInstanceForType() {
      return proto.chat.MessageRequest.getDefaultInstance();
    }

    @java.lang.Override
    public proto.chat.MessageRequest build() {
      proto.chat.MessageRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public proto.chat.MessageRequest buildPartial() {
      proto.chat.MessageRequest result = new proto.chat.MessageRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(proto.chat.MessageRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.chatMessage_ = chatMessageBuilder_ == null
            ? chatMessage_
            : chatMessageBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof proto.chat.MessageRequest) {
        return mergeFrom((proto.chat.MessageRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(proto.chat.MessageRequest other) {
      if (other == proto.chat.MessageRequest.getDefaultInstance()) return this;
      if (other.hasChatMessage()) {
        mergeChatMessage(other.getChatMessage());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getChatMessageFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private proto.chat.ChatMessage chatMessage_;
    private com.google.protobuf.SingleFieldBuilderV3<
        proto.chat.ChatMessage, proto.chat.ChatMessage.Builder, proto.chat.ChatMessageOrBuilder> chatMessageBuilder_;
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     * @return Whether the chatMessage field is set.
     */
    public boolean hasChatMessage() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     * @return The chatMessage.
     */
    public proto.chat.ChatMessage getChatMessage() {
      if (chatMessageBuilder_ == null) {
        return chatMessage_ == null ? proto.chat.ChatMessage.getDefaultInstance() : chatMessage_;
      } else {
        return chatMessageBuilder_.getMessage();
      }
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public Builder setChatMessage(proto.chat.ChatMessage value) {
      if (chatMessageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        chatMessage_ = value;
      } else {
        chatMessageBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public Builder setChatMessage(
        proto.chat.ChatMessage.Builder builderForValue) {
      if (chatMessageBuilder_ == null) {
        chatMessage_ = builderForValue.build();
      } else {
        chatMessageBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public Builder mergeChatMessage(proto.chat.ChatMessage value) {
      if (chatMessageBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          chatMessage_ != null &&
          chatMessage_ != proto.chat.ChatMessage.getDefaultInstance()) {
          getChatMessageBuilder().mergeFrom(value);
        } else {
          chatMessage_ = value;
        }
      } else {
        chatMessageBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public Builder clearChatMessage() {
      bitField0_ = (bitField0_ & ~0x00000001);
      chatMessage_ = null;
      if (chatMessageBuilder_ != null) {
        chatMessageBuilder_.dispose();
        chatMessageBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public proto.chat.ChatMessage.Builder getChatMessageBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getChatMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    public proto.chat.ChatMessageOrBuilder getChatMessageOrBuilder() {
      if (chatMessageBuilder_ != null) {
        return chatMessageBuilder_.getMessageOrBuilder();
      } else {
        return chatMessage_ == null ?
            proto.chat.ChatMessage.getDefaultInstance() : chatMessage_;
      }
    }
    /**
     * <code>.proto.chat.ChatMessage chatMessage = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        proto.chat.ChatMessage, proto.chat.ChatMessage.Builder, proto.chat.ChatMessageOrBuilder> 
        getChatMessageFieldBuilder() {
      if (chatMessageBuilder_ == null) {
        chatMessageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            proto.chat.ChatMessage, proto.chat.ChatMessage.Builder, proto.chat.ChatMessageOrBuilder>(
                getChatMessage(),
                getParentForChildren(),
                isClean());
        chatMessage_ = null;
      }
      return chatMessageBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proto.chat.MessageRequest)
  }

  // @@protoc_insertion_point(class_scope:proto.chat.MessageRequest)
  private static final proto.chat.MessageRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proto.chat.MessageRequest();
  }

  public static proto.chat.MessageRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageRequest>
      PARSER = new com.google.protobuf.AbstractParser<MessageRequest>() {
    @java.lang.Override
    public MessageRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<MessageRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public proto.chat.MessageRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
