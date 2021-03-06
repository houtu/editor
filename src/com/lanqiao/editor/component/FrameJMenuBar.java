package com.lanqiao.editor.component;

import javax.swing.JMenu;


public class FrameJMenuBar {
	public static final JMenu fileMune=new JMenu("�ļ�");
	public static final JMenu editMune=new JMenu("�༭");
	public static final JMenu searchMune=new JMenu("����");
	public static final JMenu setingMune=new JMenu("����");
	public static final JMenu winMune=new JMenu("����");
	public static final JMenu helpMune=new JMenu("����");
	public FrameJMenuBar() {
		super();
		fileMune.add(new FileMune().newItem);
		fileMune.add(new FileMune().openItem);
		fileMune.add(new FileMune().saveItem);
		fileMune.add(new FileMune().saveAsItem);
		fileMune.add(new FileMune().closeItem);
		fileMune.add(new FileMune().exitItem);
		
		editMune.add(new EditMune().redoItem);
		editMune.add(new EditMune().undoItem);
		editMune.add(new EditMune().enlargeItem);
		editMune.add(new EditMune().reduceItem);
		
		searchMune.add(new SearchMune().lookupItem);
		
	}
	
	
}
