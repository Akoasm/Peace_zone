LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := oslogic
LOCAL_SRC_FILES := oslogic.cpp \
raknet/AsynchronousFileIO.cpp \
raknet/AutoRPC.cpp \
raknet/BigInt.cpp \
raknet/BitStream.cpp \
raknet/BitStream_NoTemplate.cpp \
raknet/CCRakNetUDT.cpp \
raknet/CheckSum.cpp \
raknet/CommandParserInterface.cpp \
raknet/ConnectionGraph.cpp \
raknet/ConnectionGraph2.cpp \
raknet/ConsoleServer.cpp \
raknet/DataBlockEncryptor.cpp \
raknet/DataCompressor.cpp \
raknet/DirectoryDeltaTransfer.cpp \
raknet/DS_BytePool.cpp \
raknet/DS_ByteQueue.cpp \
raknet/DS_HuffmanEncodingTree.cpp \
raknet/DS_Table.cpp \
raknet/EmailSender.cpp \
raknet/EncodeClassName.cpp \
raknet/EpochTimeToString.cpp \
raknet/ExtendedOverlappedPool.cpp \
raknet/FileList.cpp \
raknet/FileListTransfer.cpp \
raknet/FileOperations.cpp \
raknet/FormatString.cpp \
raknet/FullyConnectedMesh.cpp \
raknet/FullyConnectedMesh2.cpp \
raknet/FunctionThread.cpp \
raknet/Gen_RPC8.cpp \
raknet/GetTime.cpp \
raknet/gettimeofday.cpp \
raknet/GridSectorizer.cpp \
raknet/HTTPConnection.cpp \
raknet/IncrementalReadInterface.cpp \
raknet/InlineFunctor.cpp \
raknet/Itoa.cpp \
raknet/LightweightDatabaseClient.cpp \
raknet/LightweightDatabaseCommon.cpp \
raknet/LightweightDatabaseServer.cpp \
raknet/LinuxStrings.cpp \
raknet/LogCommandParser.cpp \
raknet/MessageFilter.cpp \
raknet/NatPunchthroughClient.cpp \
raknet/NatPunchthroughServer.cpp \
raknet/NatTypeDetectionClient.cpp \
raknet/NatTypeDetectionCommon.cpp \
raknet/NatTypeDetectionServer.cpp \
raknet/NetworkIDManager.cpp \
raknet/NetworkIDObject.cpp \
raknet/PacketConsoleLogger.cpp \
raknet/PacketFileLogger.cpp \
raknet/PacketizedTCP.cpp \
raknet/PacketLogger.cpp \
raknet/PacketOutputWindowLogger.cpp \
raknet/PluginInterface.cpp \
raknet/PluginInterface2.cpp \
raknet/RakMemoryOverride.cpp \
raknet/RakNetCommandParser.cpp \
raknet/RakNetSocket.cpp \
raknet/RakNetStatistics.cpp \
raknet/RakNetTransport.cpp \
raknet/RakNetTransport2.cpp \
raknet/RakNetTypes.cpp \
raknet/RakNetworkFactory.cpp \
raknet/RakPeer.cpp \
raknet/RakSleep.cpp \
raknet/RakString.cpp \
raknet/RakThread.cpp \
raknet/Rand.cpp \
raknet/ReadyEvent.cpp \
raknet/ReliabilityLayer.cpp \
raknet/ReplicaManager.cpp \
raknet/ReplicaManager2.cpp \
raknet/ReplicaManager3.cpp \
raknet/rijndael.cpp \
raknet/Router.cpp \
raknet/RPCMap.cpp \
raknet/RSACrypt.cpp \
raknet/SendToThread.cpp \
raknet/SHA1.cpp \
raknet/SignaledEvent.cpp \
raknet/SimpleMutex.cpp \
raknet/SocketLayer.cpp \
raknet/StringCompressor.cpp \
raknet/StringTable.cpp \
raknet/SuperFastHash.cpp \
raknet/SystemAddressList.cpp \
raknet/TableSerializer.cpp \
raknet/TCPInterface.cpp \
raknet/TelnetTransport.cpp \
raknet/ThreadsafePacketLogger.cpp \
raknet/UDPForwarder.cpp \
raknet/UDPProxyClient.cpp \
raknet/UDPProxyCoordinator.cpp \
raknet/UDPProxyServer.cpp \
raknet/VariadicSQLParser.cpp \
raknet/WSAStartupSingleton.cpp \
raknet/_FindFirst.cpp \
NetBase.cpp \
NetInterface.cpp


LOCAL_C_INCLUDES += raknet

LOCAL_CPPFLAGS += -fpermissive
LOCAL_CPPFLAGS += -fexceptions
LOCAL_LDLIBS :=-llog

include $(BUILD_SHARED_LIBRARY)

