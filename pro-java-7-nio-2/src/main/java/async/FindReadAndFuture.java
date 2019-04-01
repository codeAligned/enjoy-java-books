package async;

import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class FindReadAndFuture {

	public static void main(String[] args) throws URISyntaxException {
		ByteBuffer buffer = ByteBuffer.allocate(100);
		String encoding = System.getProperty("file.encoding");

		Path path = Paths.get(FindReadAndFuture.class.getResource("/async/story.txt").toURI());
		try (AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {

			Future<Integer> result = asynchronousFileChannel.read(buffer, 0);

			while (!result.isDone()) {
				System.out.println("Do something else while reading ...");
			}

			System.out.println("Read done: " + result.isDone());
			System.out.println("Bytes read: " + result.get());

		} catch (Exception ex) {
			System.err.println(ex);
		}

		buffer.flip();
		System.out.print(Charset.forName(encoding).decode(buffer));
		buffer.clear();
	}
}
