package chap3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileTest extends Frame implements ActionListener {
	private TextField enter;
	private TextArea output;

	public FileTest() {
		super("File 클래스 테스트");
		enter = new TextField("파일 및 디렉토리명을 입력하세요");
		enter.addActionListener(this);
		output = new TextArea();
		add(enter, BorderLayout.NORTH);
		add(output, BorderLayout.CENTER);
		addWindowListener(new WinListener());
		setSize(400, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		File name = new File(e.getActionCommand()); // 텍스트 필드의 파일이름을 읽음
		if (name.exists()) { // + 다음에 엔터를 입력하면 안됨
			output.setText(name.getName() + "이 존재한다.\n" +
					(name.isFile() ? "파일이다.\n" : "파일이 아니다.\n") +
					(name.isDirectory() ? "디렉토리이다.\n" : "디렉토리가 아니다.\n") +
					(name.isAbsolute() ? "절대경로이다.\n" : "절대경로가 아니다.\n") +
					"마지막 수정날짜은 : " + name.lastModified() +
					"\n파일의 길이는 : " + name.length() +
					"\n파일의 경로는 : " + name.getPath() +
					"\n절대경로는 : " + name.getAbsolutePath() +
					"\n상위 디렉토리는 : " + name.getParent());
			if (name.isFile()) {
				try (RandomAccessFile r = new RandomAccessFile(name, "r");) {
					StringBuffer buf = new StringBuffer();
					String text;
					output.append("\n\n");
					while ((text = r.readLine()) != null)
						buf.append(text + "\n");
					output.append(buf.toString());
				} catch (IOException e2) {
				}
			} else if (name.isDirectory()) {
				String directory[] = name.list();
				output.append("\n\n디렉토리의 내용은 :\n");
				for (int i = 0; i < directory.length; i++)
					output.append(directory[i] + "\n");
			}
		} else {
			output.setText(e.getActionCommand() + " 은 존재하지 않는다.\n");
		}
	}

	public static void main(String args[]) {
		FileTest f = new FileTest();
	}

	class WinListener extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	}
}