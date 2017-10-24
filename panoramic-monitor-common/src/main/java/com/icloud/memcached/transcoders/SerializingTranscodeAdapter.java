package com.icloud.memcached.transcoders;

import com.icloud.serialize.ObjectInput;
import com.icloud.serialize.ObjectOutput;
import com.icloud.serialize.Serialization;
import com.icloud.support.TraceErrorException;
import net.spy.memcached.transcoders.SerializingTranscoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerializingTranscodeAdapter extends SerializingTranscoder {

	private Serialization serialization;

	public Serialization getSerialization() {
		return serialization;
	}

	public void setSerialization(Serialization serialization) {
		this.serialization = serialization;
	}

	@Override
	protected byte[] serialize(Object o) {
		if (o == null || serialization == null || !(serialization instanceof Serialization)) {
			// TODO Auto-generated method stub
			return super.serialize(o);
		}
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutput objectOutput = serialization.serialize(byteArrayOutputStream);
			objectOutput.writeObject(o);
			objectOutput.flushBuffer();
		} catch (IOException e) {
			 getLogger().warn("Non-serializable object", e);
			 throw new TraceErrorException("Non-serializable object", e);
		}
		return byteArrayOutputStream.toByteArray();
	}

	@Override
	protected Object deserialize(byte[] in) {
		if (in == null || serialization == null || !(serialization instanceof Serialization)) {
			// TODO Auto-generated method stub
			return super.deserialize(in);
		}

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(in);
		try {
			ObjectInput deserialize = serialization.deserialize(byteArrayInputStream);

			return deserialize.readObject();
		} catch (ClassNotFoundException e) {
			 getLogger().warn("Caught CNFE decoding %d bytes of data",
			          in == null ? 0 : in.length, e);
		} catch (IOException e) {
			getLogger().warn("Caught IOException decoding %d bytes of data",
			          in == null ? 0 : in.length, e);
		}
		return null;
	}

}
