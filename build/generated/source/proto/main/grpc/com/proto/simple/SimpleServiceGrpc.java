package com.proto.simple;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: simple/simple.proto")
public final class SimpleServiceGrpc {

  private SimpleServiceGrpc() {}

  public static final String SERVICE_NAME = "simple.SimpleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.simple.SimpleMessage,
      com.proto.simple.SimpleMessage> getSimpleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Simple",
      requestType = com.proto.simple.SimpleMessage.class,
      responseType = com.proto.simple.SimpleMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.simple.SimpleMessage,
      com.proto.simple.SimpleMessage> getSimpleMethod() {
    io.grpc.MethodDescriptor<com.proto.simple.SimpleMessage, com.proto.simple.SimpleMessage> getSimpleMethod;
    if ((getSimpleMethod = SimpleServiceGrpc.getSimpleMethod) == null) {
      synchronized (SimpleServiceGrpc.class) {
        if ((getSimpleMethod = SimpleServiceGrpc.getSimpleMethod) == null) {
          SimpleServiceGrpc.getSimpleMethod = getSimpleMethod =
              io.grpc.MethodDescriptor.<com.proto.simple.SimpleMessage, com.proto.simple.SimpleMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Simple"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.simple.SimpleMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.simple.SimpleMessage.getDefaultInstance()))
              .setSchemaDescriptor(new SimpleServiceMethodDescriptorSupplier("Simple"))
              .build();
        }
      }
    }
    return getSimpleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SimpleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimpleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimpleServiceStub>() {
        @java.lang.Override
        public SimpleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimpleServiceStub(channel, callOptions);
        }
      };
    return SimpleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SimpleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimpleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimpleServiceBlockingStub>() {
        @java.lang.Override
        public SimpleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimpleServiceBlockingStub(channel, callOptions);
        }
      };
    return SimpleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SimpleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SimpleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SimpleServiceFutureStub>() {
        @java.lang.Override
        public SimpleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SimpleServiceFutureStub(channel, callOptions);
        }
      };
    return SimpleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SimpleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void simple(com.proto.simple.SimpleMessage request,
        io.grpc.stub.StreamObserver<com.proto.simple.SimpleMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSimpleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSimpleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.simple.SimpleMessage,
                com.proto.simple.SimpleMessage>(
                  this, METHODID_SIMPLE)))
          .build();
    }
  }

  /**
   */
  public static final class SimpleServiceStub extends io.grpc.stub.AbstractAsyncStub<SimpleServiceStub> {
    private SimpleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimpleServiceStub(channel, callOptions);
    }

    /**
     */
    public void simple(com.proto.simple.SimpleMessage request,
        io.grpc.stub.StreamObserver<com.proto.simple.SimpleMessage> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSimpleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SimpleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SimpleServiceBlockingStub> {
    private SimpleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimpleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.simple.SimpleMessage simple(com.proto.simple.SimpleMessage request) {
      return blockingUnaryCall(
          getChannel(), getSimpleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SimpleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SimpleServiceFutureStub> {
    private SimpleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SimpleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SimpleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.simple.SimpleMessage> simple(
        com.proto.simple.SimpleMessage request) {
      return futureUnaryCall(
          getChannel().newCall(getSimpleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SIMPLE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SimpleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SimpleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SIMPLE:
          serviceImpl.simple((com.proto.simple.SimpleMessage) request,
              (io.grpc.stub.StreamObserver<com.proto.simple.SimpleMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SimpleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SimpleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.simple.Simple.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SimpleService");
    }
  }

  private static final class SimpleServiceFileDescriptorSupplier
      extends SimpleServiceBaseDescriptorSupplier {
    SimpleServiceFileDescriptorSupplier() {}
  }

  private static final class SimpleServiceMethodDescriptorSupplier
      extends SimpleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SimpleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SimpleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SimpleServiceFileDescriptorSupplier())
              .addMethod(getSimpleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
