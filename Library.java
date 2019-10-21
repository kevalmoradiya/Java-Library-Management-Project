import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import java.sql.*;


class book extends JFrame implements ActionListener,ItemListener
{

JTable jt1;
JScrollPane jsp1;
	int maxbook,tbookid=1;
	public int flag1=0;
    JPanel jpb,h1,h2,h3,pwarn;
    JTextField jbid,jt,jau,jno,jpid,jpr,jpn,jadd,jbn;
    JLabel lbid,lt,lau,lno,lpid,lpr,lpn,ladd,lbn,mp;
    JButton addb;
    JRadioButton pyes,pnot,newbook,update;
    ButtonGroup pb,nb;
    TextArea jta;
    JButton reg,iss,ret,newb,fine,bdet,modFine,modNoOfBooks,crUser,fmemo;

     JLabel ftitle,fmn,fmname,fmi,fmid,fbkdetail[][],ftotal,famt;
    JPanel jpret,jpretfine;
    JPanel jpissue;
    JTextField tissmid,tissbid[];//tissbid1,tissbid2,tissbid3;
    JTextField tretmid;
    JRadioButton jrissue[][];//,one,two,three,four;
    JRadioButton rone,rtwo,rthree,rfour;
    ButtonGroup bgiss,bgret;
    JButton jbiss,jbok,jbret,jbretmidok;
    JLabel retb,lretmid,issno,retno,issue,lissmid;
    JLabel lissbid[],lissbid1,lissbid2,lissbid3;
    JLabel lretbid1,lretbid2,lretbid3;
     Checkbox ch[];
    
    JPanel jmp,jlg;
    JLabel jreg,jln,jla,jld,jlm,jlmail,jlphone;
    JLabel jln1,jla1,jld1,jlphone1,jlmail1,jlm1;
    JTextField jmid,jmname,jmdept,jmmail,jmphone;
    JTextField jmid1,jmname1,jmdept1,jmphone1,jmmail1;
    JRadioButton rs,rt;
    TextArea jmadd;
    TextArea jmadd1;
    ButtonGroup bg;
    JButton jmem;
    Font f,f3;
    JLabel userlabel,passlabel;
    JTextField loginfield;
    JPasswordField passfield,passWord,confPassWord;
    JButton LoginButton,ExitButton;
	//JButton LoginAsAdmin;

    JLabel bkdt,pbdt;
	//keval
	JLabel tec,stu,booknte,bookdte,booknst,bookdst,upper;
	JTextField bt,bs,dt,ds;
	JPanel mod1;
	JButton b1;
	int pp,qq,rr,ss;
	int durationx[]=new int[5];
	int noofbooksx[]=new int[5];

	
	String classname = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin://@localhost:1521:XE";
	String username = "library";
	String passwd = "library";

	public int c,cf,u,cc;
	
	JTextField jfinem,jfineb;
	JRadioButton memid,bookid;
	ButtonGroup bgfine;
	JLabel finel;
	JPanel finep;
	JLabel memidl,bookidl;
	JButton kk;

JTextField createUser;
JButton usOK;
JPanel createUsers;

		JButton logout,warning;
		JPanel bkdetail;
		JLabel searchBy;
		Choice choiceOption;
		JButton Search;
		public String selected;
		JLabel searchb,searcht,searcha;
	JTextField jdisp;
	JButton go;
	
	JPanel changeFine;
	JLabel level;
	JTextField jlevel;
	JButton modify;
		
	JLabel mod[];
	JTextField modf1[],modf2[],modf3[];
	JLabel from,to,Rs;
	JLabel rest;
	JTextField jrest;
	public int n;
	JButton change;
	JButton kkk;
	
	JPanel user_detail1,user_detail2;
	JButton search,search_ok,detail_ok;
	JTextField search_id;
	JLabel search_label;
	JTextField user_status;
	JButton historry;
	JPanel his;
    book(String s)
    {
              try{
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
}
catch(Exception e)
{
System.out.println(e);
} 
        
       setLayout(null);
	   n=0;
	   jrissue=new JRadioButton[2][4];
	   tissbid=new JTextField[8];
	   lissbid=new JLabel[8];
	ch=new Checkbox[8];
		fbkdetail=new JLabel[9][2];	
		mod=new JLabel[8];
		modf1=new JTextField[8];
		modf2=new JTextField[8];
		modf3=new JTextField[8];
       Container cont=getContentPane();
       cont.setLayout(null);
       f=new Font("Times New Roman",Font.BOLD,25);
         f3=new Font("Times New Roman",Font.BOLD,15);
		  Font ff=new Font("Times New Roman",Font.BOLD,25);
	 
		 h1=new JPanel();
       h2=new JPanel();
       h3=new JPanel();
/*	   
logout=new JButton("Logout");
logout.setBounds(1150,75,150,30); logout.setFont(ff);
h1.add(logout);
logout.addActionListener(this);
*/
	  tablecreate();
     // To INSERT INTO CATEGORY TABLE //
	   insCat();
	insLibrarian();
	  maxbook=maxbookissue();
		jlg=new JPanel();
		mp=new JLabel(new ImageIcon("1.png"));
		jlg.setBounds(0,0,1360,760);
		mp.setBounds(0,0,1360,760);
		jlg.setLayout(null);
		jlg.setVisible(true);
		jlg.add(mp);
	    login(mp);    
  
		jmp=new JPanel();
		jmp.setBounds(0,0,1370,770);
		jmp.setLayout(null);
		jmp.setVisible(false);
   
	register(jmp);
	
	
	     mod1=new JPanel();
		mod1.setBounds(0,0,1185,660);
		mod1.setLayout(null);
		mod1.setVisible(false);
		
	modify();

            
       jpissue=new JPanel();
       jpissue.setLayout(null);
       jpb=new JPanel();
       jpb.setLayout(null);
      
       
     pwarn=new JPanel();
		pwarn.setLayout(null);
        pwarn.setBounds(0,0,1185,660);
       pwarn.setVisible(false);
    

       jpissue.setBounds(0,0,1185,660);
       jpissue.setVisible(false);
       
    issue(jpissue);
       
		 jpret=new JPanel();
		jpret.setBounds(0,0,1185,660);
		jpret.setLayout(null);
		jpret.setVisible(false);

	preturn(jpret);

	
			 jpretfine=new JPanel();
		jpretfine.setBounds(0,0,1185,660);
		jpretfine.setLayout(null);
		jpretfine.setVisible(false);
		totalfine(jpretfine);

		upper=new JLabel(new ImageIcon("book.png"));
		
		changeFine=new JPanel();
		changeFine.setLayout(null);
		
		level=new JLabel("Enter No Of Levels");
		jlevel=new JTextField(100);
		modify=new JButton("Modify");
		modify.addActionListener(this);
		
		
		level.setBounds(50,100,250,30); level.setFont(ff);
		jlevel.setBounds(330,100,120,25); jlevel.setFont(ff);
		modify.setBounds(470,100,150,30); modify.setFont(ff);
		
		from=new JLabel("From");
		to=new JLabel("To");
		Rs=new JLabel("Fine Value");
		
		Font ffine=new Font("Times New Roman",Font.BOLD,15);
		
		from.setBounds(220,150,100,25);  from.setFont(ffine);
		to.setBounds(340,150,100,25); to.setFont(ffine);
		Rs.setBounds(460,150,100,25); Rs.setFont(ffine);
		
		change=new JButton("Change");
		change.setBounds(700,400,100,30); change.setFont(ffine);
		change.addActionListener(this);
		changeFine.add(from); from.setVisible(false);
		changeFine.add(to);  to.setVisible(false);
		changeFine.add(Rs); Rs.setVisible(false);
		changeFine.add(change); change.setVisible(false);
		
		changeFine.add(level);
		changeFine.add(jlevel);
		changeFine.add(modify);
		
		
       h1.setLayout(null);
       h2.setLayout(null);
       h3.setLayout(null);
	   
		changeFine.setBounds(0,0,1185,660);
		
       h1.setBounds(0,0,1360,125);
       h2.setBounds(0,125,225,650);
       h3.setBounds(225,125,1185,650);
	   
	   
	 upper.setBounds(0,0,1360,125);
	   h1.add(upper);
	   
	      logout=new JButton(new ImageIcon("LOGOUT.png"));
       logout.setBounds(1200,0,150,30);
	   logout.setFont(ff);
       logout.setActionCommand("Logout");
	   upper.add(logout);
       logout.addActionListener(this);
       
        warning=new JButton(new ImageIcon("WARNING.jpg"));
	   warning.setBounds(1200,50,150,30);
	   warning.setFont(ff);
	   warning.setActionCommand("warning");
	   warning.addActionListener(this);
	   upper.add(warning);
	   
	   user_detail1=new JPanel();
	   user_detail1.setLayout(null);
	   user_detail1.setBounds(0,0,1185,660);
	   
	   user_detail2=new JPanel();
	   user_detail2.setLayout(null);
	   user_detail2.setBounds(0,0,1185,660);
	   
	   
	   search_label=new JLabel("Enter ID");
	   search_label.setBounds(100,100,200,25);
	   search_label.setFont(ff);
	   
	   search=new JButton(new ImageIcon("USERDETAIL.jpg"));
	   search.setBounds(1150,95,200,30);
	   search.setFont(ff);
	   search.setActionCommand("search");
	   search.addActionListener(this);
	   upper.add(search);
	   
	   search_id=new JTextField(50);
	   search_id.setBounds(300,100,150,25);
	   search_id.setFont(ff);
	   
	   
	   search_ok=new JButton("Search");
	   search_ok.setBounds(550,100,150,35);
	   //search_ok.setFont(ff);
	   search_ok.setActionCommand("search_ok");
	   search_ok.addActionListener(this);
	   
	   
	   
	   user_detail1.add(search_ok);
	   user_detail1.add(search_id);
	   user_detail1.add(search_label);
       
       
		addb=new JButton("ADD");
		addb.setBounds(400,500,170,45);
		 addb.addActionListener(this);
		addb.setFont(f);
		
		bkdetail=new JPanel();
		bkdetail.setLayout(null);
		bkdetail.setBounds(0,0,1185,660);
		
		searchBy=new JLabel("Search BY");
		choiceOption=new Choice();
		choiceOption.add("BOOK ID");
		choiceOption.add("Author");
		choiceOption.add("Title");
		searchBy.setBounds(30,50,150,30); searchBy.setFont(ff);
		Font cFont=new Font("Times New Roman",Font.BOLD,20);
		choiceOption.setBounds(200,50,150,100); choiceOption.setFont(cFont);
		Search=new JButton("Search");
		Search.setBounds(380,50,150,30); Search.setFont(ff);
		Search.addActionListener(this);
		choiceOption.addItemListener(this);
		selected="BOOK ID";
		
		newbook=new JRadioButton("New Book",true);cc=1;
		update=new JRadioButton("Update");
		newbook.setActionCommand("NBook");
		update.setActionCommand("Update");
		newbook.addActionListener(this);
		update.addActionListener(this);
		newbook.setBounds(50,30,100,30);
		update.setBounds(175,30,100,30);
		newbook.setFont(ffine);
		update.setFont(ffine);
		nb=new ButtonGroup();
		nb.add(newbook);
		nb.add(update);
		
		
		Font fdisp;
	fdisp=new Font("Times New Roman",Font.BOLD,25);
	searchb=new JLabel("BOOK ID"); searchb.setFont(fdisp);
	searchb.setBounds(30,120,150,30); searchb.setVisible(false);
	
	searcha=new JLabel("Author"); searcha.setFont(fdisp);
	searcha.setBounds(30,120,150,30); searcha.setVisible(false);
	
	searcht=new JLabel("Title"); searcht.setFont(fdisp);
	searcht.setBounds(30,120,150,30); searcht.setVisible(false);
	
		jdisp=new JTextField(250);
		jdisp.setBounds(200,120,250,28); jdisp.setFont(fdisp); jdisp.setVisible(false);
		go=new JButton("GO");
		go.setBounds(480,120,100,30); go.setFont(fdisp); go.setVisible(false);
		go.addActionListener(this);
	
	bkdetail.add(searchb);
	bkdetail.add(searcha);
	bkdetail.add(searcht);
	
	bkdetail.add(jdisp);
	bkdetail.add(go);
		
		
		
		
		bkdetail.add(searchBy);
		bkdetail.add(choiceOption);
		bkdetail.add(Search);
       
       
              reg=new JButton(new ImageIcon("REGISTER.png"));
	   reg.setActionCommand("Register");
       iss=new JButton(new ImageIcon("ISSUE.png"));
	   iss.setActionCommand("ISSUE");
       ret=new JButton(new ImageIcon("RETURN.png"));
	   ret.setActionCommand("Return");
       newb=new JButton(new ImageIcon("NEWBOOKS.png"));
	   newb.setActionCommand("New Books");
       fine=new JButton(new ImageIcon("FINE.png"));
	   fine.setActionCommand("Fine");
       bdet=new JButton(new ImageIcon("BOOKDETAILS.png"));
	   bdet.setActionCommand("Book Details");
	   modFine=new JButton(new ImageIcon("MODIFYFINE.png"));
	   modFine.setActionCommand("Modify Fine");
	   modNoOfBooks=new JButton(new ImageIcon("MODIFYMAXBOOKS.png"));
	   modNoOfBooks.setActionCommand("Modifybd");
	   crUser=new JButton(new ImageIcon("CREATEUSER.png"));
	   crUser.setActionCommand("Create User");
	   historry=new JButton(new ImageIcon("HISTORY.jpg"));
	   historry.setActionCommand("History");
	   historry.addActionListener(this);
       
       reg.setBounds(0,15,225,40); reg.setFont(ff);
       iss.setBounds(0,70,225,40); iss.setFont(ff);
       ret.setBounds(0,125,225,40); ret.setFont(ff);
       newb.setBounds(0,180,225,40); newb.setFont(ff);
       fine.setBounds(0,235,225,40); fine.setFont(ff);
       bdet.setBounds(0,290,225,40); bdet.setFont(ff);
       modFine.setBounds(0,345,225,40); modFine.setFont(ff);
	   Font fs=new Font("Times New Roman",Font.BOLD,22);
	   modNoOfBooks.setBounds(0,400,225,40); modNoOfBooks.setFont(fs);
	   crUser.setBounds(0,455,225,40); crUser.setFont(ff);
	   historry.setBounds(0,510,225,40); historry.setFont(ff);
	   reg.addActionListener(this);
	   
       iss.addActionListener(this);
       ret.addActionListener(this);
       newb.addActionListener(this);
       fine.addActionListener(this);
       bdet.addActionListener(this);
       modFine.addActionListener(this); 
	   modNoOfBooks.addActionListener(this); 
	   crUser.addActionListener(this);
	   
       h2.add(reg);
       h2.add(iss);
       h2.add(ret);
       h2.add(newb);
       h2.add(fine);
       h2.add(bdet);
	   h2.add(modFine);
	   h2.add(modNoOfBooks);
	   h2.add(crUser);
	   h2.add(historry);
	   
	   his=new JPanel();
	   his.setLayout(null);
	   	his.setBounds(0,0,1185,660);
	
	   
       bkdt=new JLabel("Book Detail"); bkdt.setFont(ff);
       pbdt=new JLabel("Publisher Detail"); pbdt.setFont(ff);
       
       bkdt.setBounds(120,80,250,50);
       pbdt.setBounds(480,80,350,50);
       jta=new TextArea();
       jta.setRows(50);
       
      jta.setBounds(650,240,200,100); 
       
       jbid=new JTextField(20); jbid.setFont(f);
       jt=new JTextField(50); jt.setFont(f);
       jau=new JTextField(50); jau.setFont(f); 
       jbn=new JTextField(50); jbn.setFont(f);
      
       jno=new JTextField(50); jno.setFont(f);
       jpid=new JTextField(10); jpid.setFont(f);
       
       jpr=new JTextField(5); jpr.setFont(f); 
       
       jpn=new JTextField(30); jpn.setFont(f);
       jadd=new JTextField(150); jadd.setFont(f);
       
   
	createUsers=new JPanel();
	createUsers.setLayout(null);

createUser=new JTextField(150);
passWord=new JPasswordField(150);
confPassWord=new JPasswordField(150);
JLabel UserName=new JLabel("UserName");
JLabel Password=new JLabel("Password");
JLabel ConfPass=new JLabel("Confirm Password");
usOK=new JButton("Create");
usOK.addActionListener(this);

passWord.setEchoChar('*');
confPassWord.setEchoChar('*');
UserName.setBounds(30,100,250,30); UserName.setFont(ff);
Password.setBounds(30,150,250,30); Password.setFont(ff);
ConfPass.setBounds(30,200,250,30); ConfPass.setFont(ff);

createUser.setBounds(300,100,250,25); createUser.setFont(ff);
passWord.setBounds(300,150,250,25); passWord.setFont(ff);
confPassWord.setBounds(300,200,250,25); confPassWord.setFont(ff);

usOK.setBounds(300,250,120,30); usOK.setFont(ff);

createUsers.add(UserName); createUsers.add(Password); createUsers.add(ConfPass);
createUsers.add(createUser); createUsers.add(passWord); createUsers.add(confPassWord); createUsers.add(usOK);

       
       lbid=new JLabel("Book ID");
       lt=new JLabel("Title");
       lau=new JLabel("Author");
       lbn=new JLabel("Book Name");
       
       lno=new JLabel("NO OF BOOKS");
       lpid=new JLabel("Publisher ID");
       lpr=new JLabel("Price");
       lpn=new JLabel("Publication Name");
       ladd=new JLabel("Publisher Address");
       
      // pyes=new JRadioButton("New Publisher",true);
       //pnot=new JRadioButoon("Reguler");
       
       lbn.setBounds(80,150,180,30);
       jbn.setBounds(165,150,180,25);
       
       lau.setBounds(80,235,180,30);
       jau.setBounds(165,235,180,25);
       
       
       lpr.setBounds(80,320,180,30);
       jpr.setBounds(165,320,180,25);
      
       //ladd.setBounds(460,320,180,30); 
	   //ladd.setVisible(false);
       //jpr.setBounds(650,320,180,25);
       
       ladd.setBounds(460,240,180,30);
       //jpn.setBounds(650,240,180,25);

       lpn.setBounds(460,150,180,30);
       jpn.setBounds(650,150,180,25);
       
      
       //ladd.setBounds(460,410,180,30);
       
       lno.setBounds(80,410,180,30);
       jno.setBounds(165,410,180,25);

	finep=new JPanel();
	finep.setBounds(0,0,1185,660);

finep.setLayout(null);
 	
	jfinem=new JTextField(250);

	memidl=new JLabel("Member ID");

	memidl.setBounds(30,100,250,30);  memidl.setFont(ff);

	jfinem.setBounds(300,100,250,25); jfinem.setFont(ff);
	   jta.setFont(ff);

	kk=new JButton("OK"); kk.setFont(ff);
	kk.setBounds(580,100,100,30);
	kk.addActionListener(this);
	
	kkk=new JButton("OK");
	kk.setFont(ff);
	kkk.setBounds(580,400,100,30);
	kkk.setActionCommand("Fine OK");
	kkk.addActionListener(this);
 finep.add(memidl); finep.add(jfinem);  finep.add(kk); finep.add(kkk);
 kkk.setVisible(false);
finep.setVisible(false);
	   
      //jpb.add(lbid);
       //jpb.add(jbid);
         jpb.add(newbook);
	   jpb.add(update);

       jpb.add(lt); jpb.add(lau); jpb.add(lno); jpb.add(lpid); jpb.add(lpr); jpb.add(lpn); jpb.add(ladd);
       jpb.add(jt); jpb.add(jau); jpb.add(jno); jpb.add(jpid); jpb.add(jpr); jpb.add(jpn); jpb.add(jadd);
       jpb.add(addb); jpb.add(lbn); jpb.add(jbn); jpb.add(jta); jpb.add(bkdt); jpb.add(pbdt);
       jpb.setBounds(0,0,1185,660);
     // jpb.setBackground(Color.darkGray);
       jpb.setVisible(false);
    
   
   
    //h3.add(jlg);
    h3.add(jmp);
     h3.add(jpissue);   
    h3.add(jpret);
h3.add(jpretfine);
    h3.add(finep); createUsers.setVisible(false);
 	createUsers.setBounds(0,0,1185,660);
	h3.add(createUsers);
	h3.add(bkdetail);
	h3.add(pwarn);
	h3.add(changeFine); changeFine.setVisible(false);
	bkdetail.setVisible(false);
        jmp.setVisible(false);
        
        h3.add(jpb); h3.add(jmp);
	h3.add(user_detail1);
user_detail1.setVisible(false);
	h3.add(user_detail2);
	his.setVisible(false);
	
	h3.add(his);
	
user_detail2.setVisible(false);
       h1.setBackground(Color.LIGHT_GRAY);
       h2.setBackground(Color.black);
       h3.setBackground(Color.GRAY);
       
       
      h1.setVisible(false);
      h2.setVisible(false);
      h3.setVisible(false);
       
       
       cont.add(h1); cont.add(h2); cont.add(h3); cont.add(jlg);
 
       detail();
        
    }
	
	public void hisadd()
	{
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
int n=0;
ResultSet rs;
rs=st.executeQuery("select * from history order by iss_date desc ");
String head[]={"BOOK_ID","MEMBER_ID","ISSUE_DATE","RETURN_DATE","FINE"};
String data[][]=new String[50][5];
int i=0;
while(rs.next() && i<50)
{
System.out.println(" "+rs.getString("bid")+" :: "+rs.getString("mem_id")+" :: "+rs.getString("fine"));
data[i][0]=rs.getString("bid");
data[i][1]=rs.getString("mem_id");
data[i][2]=rs.getString("iss_date");
data[i][3]=rs.getString("ret_date");
data[i][4]=rs.getString("fine");
i++;
}





rs.close();
st.close();
con.close();
JTable jt1=new JTable(data,head);
//jt1.setBackground(Color.white);
Font f=new Font("Arial",Font.BOLD,20);
jt1.setFont(f);
jt1.setEnabled(false);
jt1.setRowHeight(20);
JScrollPane jsp1=new JScrollPane(jt1);

jsp1.setBounds(150,150,600,250);
his.add(jsp1);
return;
}
catch(Exception e)
{System.out.println(e);}

	
	
	
	
	
	
	}
	
	public void modify()
{
Font ff=new Font("Times New Roman",Font.BOLD,25);
	 

tec=new JLabel("TEACHER");   
tec.setFont(f3); 
tec.setBounds(100,100,100,30);
stu=new JLabel("STUDENT");
stu.setFont(f3);
stu.setBounds(100,300,100,30);
booknte=new JLabel("NO. OF BOOKS"); 
booknte.setFont(f3);
booknte.setBounds(100,140,130,25);
bookdte=new JLabel("NO. OF DAYS");
bookdte.setFont(f3);
bookdte.setBounds(100,180,130,25);
booknst=new JLabel("NO. OF BOOKS");
booknst.setFont(f3);
booknst.setBounds(100,340,130,25);
bookdst=new JLabel("NO. OF DAYS");
bookdst.setFont(f3);
bookdst.setBounds(100,380,130,25);










try
	{
	Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement sp=con.createStatement();

		ResultSet ps=sp.executeQuery("select duration from category  ");
		int i=0;
		
		while(ps.next())
		
		{
		durationx[i]=ps.getInt("duration");
		i++;
		}
		ResultSet rs=sp.executeQuery("select no_books from category  ");
		i=0;
		while(rs.next())
		{
		noofbooksx[i]=rs.getInt("no_books");
		i++;
		}
		
		sp.close();
		con.close();
	
	}
catch(Exception e)
	{System.out.println(e);}







bt=new JTextField(2);
bt.setText(Integer.toString(noofbooksx[1]));
bt.setBounds(250,140,100,25);
dt=new JTextField(2);
dt.setText(Integer.toString(durationx[1]));
dt.setBounds(250,180,100,25);
bs=new JTextField(2);
bs.setText(Integer.toString(noofbooksx[0]));
bs.setBounds(250,340,100,25);
ds=new JTextField(2);
ds.setText(Integer.toString(durationx[0]));
ds.setBounds(250,380,100,25);


b1=new JButton("OK");
b1.setActionCommand("ok1");
b1.addActionListener(this);
b1.setBounds(100,450,50,25);


h3.add(mod1);
mod1.add(tec);mod1.add(stu);mod1.add(booknte);mod1.add(bookdte);mod1.add(booknst);mod1.add(bookdst);mod1.add(bt);mod1.add(dt);mod1.add(bs);
mod1.add(ds);
mod1.add(b1);

}


	public void disp()
	{
	//System.out.println(selected);
	if(selected.equals("BOOK ID"))
	{ searchb.setVisible(true);   searcha.setVisible(false);  searcht.setVisible(false);}
	else if(selected.equals("Author"))
	{ searcha.setVisible(true);  searchb.setVisible(false);  searcht.setVisible(false); }
	else if(selected.equals("Title"))
	{ searcht.setVisible(true);   searcha.setVisible(false);  searchb.setVisible(false);}
	

	jdisp.setVisible(true);
	go.setVisible(true);
	
	
	
	}
	
	public void modLayout()
	{
	n=Integer.parseInt(jlevel.getText());
	String strm="";
	System.out.println("modLayout");
	Font ffine=new Font("Times New Roman",Font.BOLD,15);
	for(int i=0;i<8;i++)
	{
	strm=Integer.toString(i+1);
	mod[i]=new JLabel(strm);
	mod[i].setBounds(180,200+i*35,20,25);
	mod[i].setVisible(false); mod[i].setFont(ffine);
	
	modf1[i]=new JTextField(50);
	modf2[i]=new JTextField(50);
	modf3[i]=new JTextField(50);
	
	modf1[i].setBounds(220,200+i*35,100,20); modf1[i].setVisible(false); modf1[i].setFont(ffine);
	modf2[i].setBounds(340,200+i*35,100,20); modf2[i].setVisible(false); modf2[i].setFont(ffine);
	modf3[i].setBounds(460,200+i*35,100,20); modf3[i].setVisible(false); modf3[i].setFont(ffine);
	
	changeFine.add(mod[i]); changeFine.add(modf1[i]); changeFine.add(modf2[i]); changeFine.add(modf3[i]);
	}
		rest=new JLabel("& Further");
	jrest=new JTextField(50);
	rest.setBounds(180,200+(n-1)*35,120,25); rest.setFont(ffine); rest.setVisible(false);
	jrest.setBounds(320,200+(n-1)*35,100,20); jrest.setFont(ffine);  jrest.setVisible(false);
	changeFine.add(rest); changeFine.add(jrest);
	

	from.setVisible(true);
	to.setVisible(true);
	Rs.setVisible(true);
	for(int i=0;i<n-1;i++)
	{
	mod[i].setVisible(true);
	modf1[i].setVisible(true);
	modf2[i].setVisible(true);
	modf3[i].setVisible(true);
	}
	
	rest.setVisible(true);
	jrest.setVisible(true);
	change.setVisible(true);
		
	}
	
	public void modFineValue()
	{
	int i;
	int n1[]=new int[n-1];
	int n2[]=new int[n-1];
	int n3[]=new int[n-1];
	int further=Integer.parseInt(jrest.getText());
	int chn=0;
	try{
	for(i=0;i<n-1;i++)
	{
	n1[i]=Integer.parseInt(modf1[i].getText());
	n2[i]=Integer.parseInt(modf2[i].getText());
	n3[i]=Integer.parseInt(modf3[i].getText());
	}
	for(i=0;i<n-2;i++)
	{
	if(n1[0] != 1 || (n1[i+1]-n2[i]) != 1 || (n2[i]-n1[i])<0 || (n2[i+1]-n1[i+1])<0)
	{System.out.println(" :: "+n1[0]+" :: "+(n1[i+1]-n2[i]));
	JOptionPane.showMessageDialog(changeFine,"ENTERED VALUE ARE INVALID..!!!","Error",0); chn=1; break;}
	}
	}
	catch(Exception e)
	{}
	try
	{
	
		for(i=0;i<n-1;i++)
		{
		modf1[i].setText("");
		modf2[i].setText("");
		modf3[i].setText("");
		}
	jrest.setText("");
	if(chn==1)
	{
	return;
	}
	
	}
	catch(Exception e)
	{System.out.println(e);}
	try
	{
	Class.forName(classname);
	Connection con=DriverManager.getConnection(url,username,passwd);
	Statement st=con.createStatement();
	
	st.execute("delete from fine");
	
	for(i=0;i<n-1;i++)
	{  
		try
		{
	st.executeUpdate("insert into fine values("+(i+1)+","+(n2[i]-n1[i]+1)+","+n3[i]+")");
		}
		catch(Exception e)
		{
		System.out.println(i+" :: "+e);
		}
	}
	st.executeUpdate("insert into fine values("+n+",0,"+further+")");
	}
	catch(Exception e)
	{}
	
	}
	
	
	
	public void bookDetail()
	{
	
	try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from book");
long n;
String tit,aut;
if(selected.equals("BOOK ID"))
{
n=Long.parseLong(jdisp.getText());
rs=st.executeQuery("select b.bid,b.title,b.author,b.availibility,p.pname from book b,publisher p where b.bid="+n+" and p.pid in(select pid from book where bid="+n+")");
}
else if(selected.equals("Title"))
{
tit=jdisp.getText();
rs=st.executeQuery("select b.bid,b.title,b.author,b.availibility,p.pname from book b,publisher p where b.bid in(select bid from book where lower(title) like lower('%"+tit+"%')) and p.pid in(select pid from book where bid in(select bid from book where lower(title) like lower('%"+tit+"%')))");
}
else if(selected.equals("Author"))
{
aut=jdisp.getText();
rs=st.executeQuery("select b.bid,b.title,b.author,b.availibility,p.pname from book b,publisher p where b.bid in(select bid from book where lower(author) like lower('%"+aut+"%')) and p.pid in(select pid from book where bid in(select bid from book where lower(author) like lower('%"+aut+"%')))");
//rs1=st.executeQuery("select pname from publisher where pid in(select pid from book where bid in(select bid from book where lower(author) like (%"+aut+"%))");
}







 

String head[]={"BOOK_ID","Title","Author","Availibility","Publisher Name"};
String data[][]=new String[50][5];
int i=0;
while(rs.next())
{
//rs1.next();
data[i][0]=rs.getString("bid");
data[i][1]=rs.getString("title");
data[i][2]=rs.getString("author");
data[i][3]=rs.getString("availibility");
data[i][4]=rs.getString("pname");
i++;
}
/*i=0;
while(rs1.next())
{
data[i][4]=rs1.getString("pname");
i++;
}*/




//rs1.close();
rs.close();
con.close();
st.close();
JTable jt1=new JTable(data,head);
jt1.setBackground(Color.white);
Font f=new Font("Arial",Font.BOLD,20);
jt1.setFont(f);
jt1.setEnabled(false);
jt1.setRowHeight(20);
JScrollPane jsp1=new JScrollPane(jt1);

jsp1.setBounds(130,250,500,250);
bkdetail.add(jsp1);
}
catch(Exception e)
{System.out.println(e);}


}
	
	public void itemStateChanged(ItemEvent ie)
	{
	
	selected=choiceOption.getSelectedItem();
	System.out.println(selected);
	}
    
	public int maxbookTOcid(int ccid)
{
int ch;
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select duration from category where cid="+ccid+"");
		ch=0;
		rs.next();
		ch=Integer.parseInt(rs.getString("duration"));
		rs.close();
		st.close();
		con.close();
		return ch;
	}
catch(Exception e)
{
System.out.println("duration "+e);
}
return 0;
}


public void dispFine()
{
finecount();

try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
Long gt=Long.parseLong(jfinem.getText());

ResultSet rs=st.executeQuery("select count(*) from member where mem_id="+gt+"");
rs.next();
int n=rs.getInt("count(*)");

if(n!=1)
{
JOptionPane.showMessageDialog(finep,"Invalid Member_ID...!!!","Error",0);
flag1=1;
return;
}

rs=st.executeQuery("select count(*) from issue where mem_id="+gt+"");
rs.next();
n=rs.getInt("count(*)");
System.out.println(""+n);


rs=st.executeQuery("select bid,mem_id,fine from issue where mem_id="+gt+"");

String head[]={"B`OOK_ID","MEMBER_ID","FINE"};
String data[][]=new String[n][3];
int i=0;
while(rs.next())
{
System.out.println(" "+rs.getString("bid")+" :: "+rs.getString("mem_id")+" :: "+rs.getString("fine"));
data[i][0]=rs.getString("bid");
data[i][1]=rs.getString("mem_id");
data[i][2]=rs.getString("fine");
i++;
}





rs.close();
con.close();
st.close();
jt1=new JTable(data,head);
jt1.setBackground(Color.white);
Font f=new Font("Arial",Font.BOLD,20);
jt1.setFont(f);
jt1.setEnabled(false);
jt1.setRowHeight(20);
jsp1=new JScrollPane(jt1);

jsp1.setBounds(130,150,300,250);
finep.add(jsp1);
kkk.setVisible(true);
}
catch(Exception e)
{System.out.println(e);
JOptionPane.showMessageDialog(finep,"Invalid Member_ID...!!!","Error",0);
jfinem.setText("");
}

}
 
public void finecount()
{

int count=0,tot=0,i=0,frow=0,j=0,totfine=0,totdays=0;
int c[][],fine[][];
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from issue ");
		rs.next();
		count=Integer.parseInt(rs.getString("count(*)"));
		//System.out.println("count  "+count);
		c=new int[count][4];
		
		
		rs=st.executeQuery("select count(*) from fine ");
		rs.next();
		frow=Integer.parseInt(rs.getString("count(*)"));
			//System.out.println("frow  "+frow);
		fine=new int[frow][2];
		
		
		rs=st.executeQuery("select * from fine order by idx");
		i=0;
		while(rs.next())
		{
		fine[i][0]=Integer.parseInt(rs.getString("duration"));
		fine[i][1]=Integer.parseInt(rs.getString("amt"));
		//System.out.println("fine "+fine[i][0]+"  "+fine[i][1]);
		i++;
		}
		
		
		i=0;
		rs=st.executeQuery("select bid,mem_id,cid,round(sysdate-iss_date) from issue");
		while(rs.next())
		{
		c[i][0]=Integer.parseInt(rs.getString("bid"));
		c[i][1]=Integer.parseInt(rs.getString("mem_id"));
		c[i][2]=Integer.parseInt(rs.getString("cid"));
		c[i][3]=Integer.parseInt(rs.getString("round(sysdate-iss_date)"));
		System.out.println(c[i][0]+"  "+c[i][1]+"  "+c[i][2]+"  "+c[i][3]);
				
			totdays=c[i][3]-maxbookTOcid(c[i][2]);
			System.out.println(totdays);
			totfine=0;
			if(totdays>0)
			{
			
				for(j=0;j<frow-1;j++)
				{
					if(totdays >= fine[j][0])
					{
					totfine=totfine+fine[j][0]*fine[j][1];
					totdays=totdays-fine[j][0];
					}
					else
					{
					totfine=totfine+totdays*fine[j][1];
					totdays=0;
					break;
					}
				}	
				totfine=totfine+totdays*fine[frow-1][1];
				updateissue(totfine,c[i][0],c[i][1]);
				//st.executeUpdate(" update issue set fine="+totfine+"  where bid="+c[i][0]+" and mem_id="+c[i][1]+" ");
				System.out.println("FFFFF");
			}
		i++;
		}
		st.close();
		con.close();
			
	}
catch(Exception e)
	{
	System.out.println("fine count "+e);
	}



}



public void resetradio(int ii)
{
int i,j,k=0;
for(i=0;i<2;i++)
			{
				for(j=0;j<4;j++)
				{
					if(k<ii)
					{	
						jrissue[i][j].setVisible(true);
					}
					else
					{
						jrissue[i][j].setVisible(false);
					}
				k++;
				}
			}

}



public void updateissue(int totfine,int c1,int c2)
{
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		st.executeUpdate(" update issue set fine="+totfine+"  where bid="+c1+" and mem_id="+c2+" ");
		
		st.close();
		con.close();		
	}
	catch(Exception e)
	{
	System.out.println("update issue"+e);
	}



}

 
public void crUser()
{
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
String s1=createUser.getText();
String s2=passWord.getText();
String s3=confPassWord.getText();

if(s2.equals(s3))
{
	try
	{
st.executeUpdate("insert into librarian values('"+s1+"','"+s2+"')");
JOptionPane.showMessageDialog(createUsers,"User Successfully Created...","Created",1);
passWord.setText("");
confPassWord.setText("");
createUser.setText("");	

	}
	catch(Exception e)
	{
JOptionPane.showMessageDialog(createUsers,"UserName Already Occupied, Plz choose another...","Error",0);
passWord.setText("");
confPassWord.setText("");
createUser.setText("");	
}
}
else
{
JOptionPane.showMessageDialog(createUsers,"ReEnter Password...","Error",0);
passWord.setText("");
confPassWord.setText("");
}




st.close();
con.close();
}
catch(Exception e)
{}


}
public void insLibrarian()
{
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();

	try
	{
st.executeUpdate("insert into librarian values('Admin','Admin')");
	}
	catch(Exception e)
	{System.out.println(e);}

} 
catch(Exception e)
{}
}
   
boolean user_validation(String s)
{
int count=0;
try
{
Long l=Long.parseLong(s);
Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from member where mem_id="+l+"");
		rs.next();
		count=Integer.parseInt(rs.getString("count(*)"));
		rs.close();
		st.close();
		con.close();
		if(count!=0)
		{ return true; }
		else
		{ return false; }
}
catch(Exception e)
{
return false;
}



} 
 
public void actionPerformed(ActionEvent ae)
{

int no,i,j,k=0,tot;
String ss,str,st;

String s=ae.getActionCommand();
if(s.equals("Register"))
{

jmname.setText("");
jmadd.setText("");
jmdept.setText("");
jmphone.setText("");
jmmail.setText("");



bkdetail.setVisible(false); 
user_detail1.setVisible(false);
user_detail2.setVisible(false);
mod1.setVisible(false);
jpret.setVisible(false);
    jpb.setVisible(false);
jpretfine.setVisible(false);
  jmp.setVisible(true);
pwarn.setVisible(false);
    jpissue.setVisible(false);
tissmid.setEnabled(true);
finep.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
his.setVisible(false);
}
else if(s.equals("History"))
{
bkdetail.setVisible(false); 
user_detail1.setVisible(false);
user_detail2.setVisible(false);
mod1.setVisible(false);
jpret.setVisible(false);
    jpb.setVisible(false);
jpretfine.setVisible(false);
  jmp.setVisible(false);
pwarn.setVisible(false);
    jpissue.setVisible(false);
finep.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
hisadd();
his.setVisible(true);
System.out.println("History");
}
else if(s.equals("search"))
{
bkdetail.setVisible(false); 
mod1.setVisible(false);
jpret.setVisible(false);
    jpb.setVisible(false);
jpretfine.setVisible(false);
  jmp.setVisible(false);
pwarn.setVisible(false);
    jpissue.setVisible(false);
user_detail2.setVisible(false);

finep.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
his.setVisible(false);

System.out.println("AAAAA");
user_detail1.setVisible(true);
}
else if(s.equals("search_ok"))
{
System.out.println(search_id.getText());
boolean b=user_validation(search_id.getText());
System.out.println(b);
if(b)
{
 
user_detail1.setVisible(false);
user_insdetail(search_id.getText());
user_detail2.setVisible(true);
}
else
{
JOptionPane.showMessageDialog(user_detail1,"User ID doesm't exists","Error",0);
search_id.setText("");
}


}
else if(s.equals("detail_ok"))
{
user_detail2.setVisible(false);
search_id.setText("");
user_detail1.setVisible(true);

     
     jmid1.setText(""); 
    jmname1.setText("");
     jmdept1.setText("");
     jmphone1.setText("");
   jmmail1.setText("");
     jmadd1.setText("");
     user_status.setText("");

   

}
else if(s.equals("fmemo ok"))
{

jpret.setVisible(true);
resetreturn();
jpretfine.setVisible(false);
}

else if(s.equals("Fine OK"))
{
dispFine();
kkk.setVisible(false);
jfinem.setText("");
jt1.setVisible(false);
jsp1.setVisible(false);
//finep.remove(jsp1);
//finep();
}
else if(s.equals("Change"))
{ modFineValue(); }
else if(s.equals("Modify"))
{System.out.println("modify"); 
modLayout(); }
else if(s.equals("GO"))
{
bookDetail();
}
else if(s.equals("Search"))
{System.out.println("dfdfgdv");
disp();
}
else if(s.equals("Book Details"))
{jpretfine.setVisible(false);
bkdetail.setVisible(true); 
jpret.setVisible(false);
pwarn.setVisible(false);
    jpb.setVisible(false);
  jmp.setVisible(false);
    jpissue.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
tissmid.setEnabled(true);
finep.setVisible(false);
createUsers.setVisible(false);
//bookDetail();
changeFine.setVisible(false);
his.setVisible(false);
mod1.setVisible(false);
}
else if(s.equals("Logout"))
{jpretfine.setVisible(false);
bkdetail.setVisible(false); 
jpret.setVisible(false);
    jpb.setVisible(false);
  jmp.setVisible(false);
    jpissue.setVisible(false);
tissmid.setEnabled(true);
finep.setVisible(false);
pwarn.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
his.setVisible(false);
jlg.setVisible(true);
h1.setVisible(false);
h2.setVisible(false);
h3.setVisible(false);
loginfield.setText("");
passfield.setText("");
}
else if(s.equals("OK"))
{ dispFine();
if(flag1==1)
{
jfinem.setText("");
 flag1=0;
}
 }
else if(s.equals("Student"))

{c=1;
System.out.println(""+c);
}

else if(s.equals("Teacher"))

{c=2;
System.out.println(""+c);
}

else if(s.equals("ISSUE"))
{bkdetail.setVisible(false); 
    jpret.setVisible(false);
	issueclear(jpissue);
resetissue(-1);
resetradio(-1);   
 jpissue.repaint();
jpretfine.setVisible(false);
	jpissue.setVisible(true);
createUsers.setVisible(false);
changeFine.setVisible(false);
  jpb.setVisible(false);
    jmp.setVisible(false);
his.setVisible(false);
pwarn.setVisible(false);
finep.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
tissmid.setEnabled(true);
mod1.setVisible(false);	
}
else if(s.equals("Modify Fine"))
{if(u==1)
{bkdetail.setVisible(false);  changeFine.setVisible(true); jpret.setVisible(false);
	issueclear(jpissue);
jpretfine.setVisible(false);
    jpissue.repaint();
	jpissue.setVisible(false);
createUsers.setVisible(false);
his.setVisible(false);
pwarn.setVisible(false);
  jpb.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
    jmp.setVisible(false);
mod1.setVisible(false);
finep.setVisible(false);
tissmid.setEnabled(true);}
else
{JOptionPane.showMessageDialog(h3,"Access Denied","Error",0);}
}
else if(s.equals("Modifybd"))
{if(u==1)
{bkdetail.setVisible(false);  changeFine.setVisible(false);
jpretfine.setVisible(false);
  jpret.setVisible(false);
	jpissue.setVisible(false);
createUsers.setVisible(false);
his.setVisible(false);
  jpb.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
    jmp.setVisible(false);
pwarn.setVisible(false);

finep.setVisible(false);
mod1.setVisible(true);

}
else
{JOptionPane.showMessageDialog(h3,"Access Denied","Error",0);}

}


else if(s.equals("Modify Max. Books"))
{

if(u==1)
{
bkdetail.setVisible(false); changeFine.setVisible(false);
}
else
{JOptionPane.showMessageDialog(h3,"Access Denied","Error",0);}
}
else if(s.equals("Create"))
{crUser(); }
else if(s.equals("Create User"))
{if(u==1)
{bkdetail.setVisible(false);     
jpret.setVisible(false);
	issueclear(jpissue);
    jpissue.repaint();
	jpissue.setVisible(false);
  jpb.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
    jmp.setVisible(false);
changeFine.setVisible(false);
jpretfine.setVisible(false);
finep.setVisible(false);
pwarn.setVisible(false);
his.setVisible(false);
tissmid.setEnabled(false);
createUsers.setVisible(true);
mod1.setVisible(false);
}
else
{JOptionPane.showMessageDialog(h3,"Access Denied","Error",0);}
}

else if(s.equals("issue ok"))
{
String ck="",ck1="";
int f=1,ff=1;
st=tissmid.getText();
//tissmid.setEnabled(true);

//no=noofbook(st);
ss="";
no=tbookid;
			System.out.println(">>>>>>>>>"+no);
for(i=0;i<no;i++)
	{
	ss=tissbid[i].getText();
	if(!available(ss))
		{f=0;
		tissbid[i].setText("");
		ck=ck+"  "+Integer.toString(i+1);
			
		}
	else if(bookissued(ss,st))
		{
		ff=0;
		tissbid[i].setText("");
		ck1=ck1+"  "+Integer.toString(i+1);
		}
	}
	
	
	if(f==1 && ff==1)
	{
		for(i=0;i<no;i++)
		{
			ss=tissbid[i].getText();
			issuebook(st,ss);
		}
	JOptionPane.showMessageDialog(jpissue," book successfully issued....","access granted",1);	
	issueclear(jpissue);
	resetissue(-1);
	tissmid.setEnabled(true);
	resetradio(-1);   
	jpissue.repaint();	
	}		
	else 
	{
		if(f==0)
		{
		JOptionPane.showMessageDialog(jpissue," Book ID "+ck+"  does't exists.. ","Error",0);
		}
		if(ff==0)
		{
		JOptionPane.showMessageDialog(jpissue," Book ID "+ck1+" already issued by member id "+ss+" ","Error",0);
		}
	}
}
else if(s.equals("rmid ok"))
{
int bid[]=new int[8];
st=tretmid.getText();
//tretmid.setEnabled(false);

boolean b=midcheck(st);
	if(b)
	{
	no=noofissuebook(st);
		if(no != 0)
		{
		jbret.setVisible(true);
		getbid(st,bid);
	
		removecheckbox();
		showcheckbox(no,bid);
		
		}
		else
		{
		JOptionPane.showMessageDialog(jpret," No Book issued yet ","Error",0);
	
		}
	}
	else
	{
	JOptionPane.showMessageDialog(jpret," Member ID   does't exists.. ","Error",0);
	
	}
}

else if(s.equals("return ok"))
{

st=tretmid.getText();
no=noofissuebook(st);
finecount();
returnconform(st,no);
jpret.setVisible(false);
jpretfine.setVisible(true);
}


else if(s.equals("mid ok"))
{
	st=tissmid.getText();
	
	boolean b=midcheck(st);
	if(b)
	{
		
		System.out.println("member id matched...");
		no=noofbook(st);	
		if(no != 0)
		{
		jrissue[0][0].setSelected(true);
		issno.setVisible(true);
		jbiss.setVisible(true);
		for(i=0;i<2;i++)
		{
			for(j=0;j<4;j++)
			{
				if(k<no)
				{	
					jrissue[i][j].setVisible(true);
				}
				else
				{
					jrissue[i][j].setVisible(false);
				}
			k++;
			}
		}
		
		for(i=0;i<8;i++)
		{
			if(i<1)
			{
				tissbid[i].setVisible(true);
				lissbid[i].setVisible(true);
			}
			else
			{
				tissbid[i].setVisible(false);
				lissbid[i].setVisible(false);
			}
	
		}
		tissmid.setEnabled(false);

		}
		else
		{
		resetradio(-1);
		resetissue(-1);
		issno.setVisible(false);
		jbiss.setVisible(false);
		JOptionPane.showMessageDialog(jpissue,"Book Issue out of Limit"," ERROR ",0);
		tissmid.setText("");
		System.out.println("sorry....,out of limit..");
		}
	}	
	else
	{
	issno.setVisible(false);
		jbiss.setVisible(false);
	resetissue(-1);
	resetradio(-1);
	JOptionPane.showMessageDialog(jpissue,"member id does't exists..."," ERROR ",0);
			tissmid.setText("");
		System.out.println("member id does't exists...");
	}
}

for(i=0;i<8;i++)
{
	str="issue "+Integer.toString(i+1);
	
	if(s.equals(str))
	{
	System.out.println(tbookid);
	tbookid=i+1;
	resetissue(i);	
	}
		
}


if(s.equals("Return"))
{changeFine.setVisible(false);
resetreturn();
pwarn.setVisible(false);
bkdetail.setVisible(false); 
jpret.setVisible(true);
jpb.setVisible(false);
his.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
    jmp.setVisible(false);
      jpissue.setVisible(false);
finep.setVisible(false);jpretfine.setVisible(false);
createUsers.setVisible(false);
mod1.setVisible(false);
}
else if(s.equals("New Books"))
{bkdetail.setVisible(false); 
      jpret.setVisible(false);
    jpb.setVisible(true);jpretfine.setVisible(false);
    jmp.setVisible(false);
    his.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
      jpissue.setVisible(false);
tissmid.setEnabled(true);
pwarn.setVisible(false);
finep.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
}
else if(s.equals("Fine"))
{bkdetail.setVisible(false); 
System.out.println("dskfjdg");
his.setVisible(false); 
jpret.setVisible(false);
pwarn.setVisible(false);
    jpb.setVisible(false);
  jmp.setVisible(false);jpretfine.setVisible(false);
    jpissue.setVisible(false);
tissmid.setEnabled(true);
finep.setVisible(true);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
}

else if(s.equals("Login"))
{
boolean b=ckLogin();
if(loginfield.getText().equals("Admin") && b)
{ u=1; }
else
{ u=0; }
if(b)
{
System.out.println(s);
 
jlg.setVisible(false);
 h1.setVisible(true);
 h2.setVisible(true);
 h3.setVisible(true);
tissmid.setEnabled(true);
}
else
{
JOptionPane.showMessageDialog(jlg,"Usename or Password are Incorrect","Login Denied",0);

}
}

else if(s.equals("NBook"))
{
cc=1;
jpr.setEnabled(true);
jpn.setEnabled(true);
jta.setEnabled(true);
}

else if(s.equals("Update"))
{cc=2;

jpr.setEnabled(false);
jpn.setEnabled(false);
jta.setEnabled(false);
}

else if(s.equals("ADD"))
{
if(cc==1)
{
insBooknPub();
}
else
{
insBooknPub2();
}
if(flag1==1)
{
jbn.setText("");
jau.setText("");
jpr.setText("");
jno.setText("");
jpn.setText("");
jta.setText("");
flag1=0;
}
else
{}
}

else if(s.equals("Sign Up"))
{
boolean b=insMem();
if(b)
{
jmname.setText("");
jmadd.setText("");
jmdept.setText("");
jmphone.setText("");
jmmail.setText("");
}
}
//keval
else if(s.equals("warning"))
{
pwarn.setVisible(true);
bkdetail.setVisible(false); 
jpret.setVisible(false);
jpb.setVisible(false);
jmp.setVisible(false);
jpretfine.setVisible(false);
his.setVisible(false);
jpissue.setVisible(false);
user_detail1.setVisible(false);
user_detail2.setVisible(false);
finep.setVisible(false);
createUsers.setVisible(false);
changeFine.setVisible(false);
mod1.setVisible(false);
warn();

}

else if(s.equals("ok1"))
{
pp=Integer.parseInt(bt.getText());
qq=Integer.parseInt(dt.getText());
rr=Integer.parseInt(bs.getText());
ss=ds.getText();

/**bt.setText("");
bs.setText("");
dt.setText("");
ds.setText("");*/
System.out.println("ok1");


try
	{
	Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement sp=con.createStatement();

		sp.executeUpdate("update category set no_books="+pp+" where lower(ctype)='teacher' ");
		sp.executeUpdate("update category set duration="+qq+" where lower(ctype)='teacher' ");
		sp.executeUpdate("update category set no_books="+rr+" where lower(ctype)='student' ");
		sp.executeUpdate("update category set duration="+ss+" where lower(ctype)='student' ");
		
		sp.close();
		con.close();
	
	}
catch(Exception e)
	{System.out.println(e);}
}


else if(s=="Exit")
{
System.exit(0);
}
}

public boolean ckLogin()
{
boolean b=false;
try
{
Class.forName("oracle.jdbc.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from librarian");


while(rs.next())
{
	if(rs.getString("lib_id").equals(loginfield.getText()))
	{  			if(rs.getString("password").equals(passfield.getText()))
				{ b=true;  break;}
	}
	else
	{}
}


rs.close();
st.close();
con.close();
}
catch(Exception e)
{}
return b;
}




public void totalfine(JPanel jpretfine)
{
int i,j;
Font ff3=new Font("Times New Roman",Font.BOLD,20);
	// ftitle,fmn,fmname,fmi,fmid,fbkdetail[][],ftotal;
	ftitle=new JLabel("FINE MEMO");
	
	
	fmemo=new JButton("OK");
	fmemo.setBounds(600,510,80,40);
	fmemo.setActionCommand("fmemo ok");
	fmemo.setFont(f3);
	fmemo.addActionListener(this);
	ftitle.setBounds(400,20,300,50);
		ftitle.setVisible(true);
		ftitle.setEnabled(false);
		ftitle.setFont(f);
		jpretfine.add(ftitle);
	fmn=new JLabel("Member Name:");
	fmn.setBounds(200,70,200,40);
		fmn.setVisible(true);
	fmn.setEnabled(false);
	fmn.setFont(f3);
	jpretfine.add(fmn);
	fmname=new JLabel("name");
	fmname.setBounds(400,70,200,40);
		fmname.setVisible(true);
	fmname.setEnabled(false);
	fmname.setFont(f3);
	jpretfine.add(fmname);	

	fmi=new JLabel("Member ID:");
	fmi.setBounds(200,110,200,40);
		fmi.setVisible(true);
	fmi.setEnabled(false);
	fmi.setFont(f3);
	jpretfine.add(fmi);
	
	fmid=new JLabel("id:");
	fmid.setBounds(400,110,200,40);
		fmid.setVisible(true);
	fmid.setEnabled(false);
	fmid.setFont(f3);
	jpretfine.add(fmid);
	fbkdetail[0][0]=new JLabel("Book ID");
	fbkdetail[0][0].setBounds(200,160,200,40);
	fbkdetail[0][0].setVisible(true);
	fbkdetail[0][0].setEnabled(false);
	fbkdetail[0][0].setFont(f3);
	jpretfine.add(fbkdetail[0][0]);
	fbkdetail[0][1]=new JLabel("Fine");
	fbkdetail[0][1].setBounds(500,160,200,40);
	fbkdetail[0][1].setVisible(true);
	fbkdetail[0][1].setEnabled(false);
	fbkdetail[0][1].setFont(f3);
	jpretfine.add(fbkdetail[0][1]);
	for(i=1;i<9;i++)
	{
	
			fbkdetail[i][0]=new JLabel("");
			fbkdetail[i][0].setBounds(200,175+30*i,200,25);
			fbkdetail[i][0].setVisible(false);
			fbkdetail[i][0].setEnabled(false);
			fbkdetail[i][0].setFont(f3);
		jpretfine.add(fbkdetail[i][0]);
			fbkdetail[i][1]=new JLabel("Fine");
			fbkdetail[i][1].setBounds(500,175+30*i,200,25);
			fbkdetail[i][1].setVisible(true);
			fbkdetail[i][1].setEnabled(false);
			fbkdetail[i][1].setFont(f3);
		jpretfine.add(fbkdetail[i][1]);
	}
	
	ftotal=new JLabel("Total Fine:");
	ftotal.setBounds(350,460,150,30);
	ftotal.setVisible(true);
	ftotal.setEnabled(false);
	ftotal.setFont(ff3);
	jpretfine.add(ftotal);
	jpretfine.add(fmemo);

	famt=new JLabel("555");
	famt.setBounds(500,460,150,30);
	famt.setVisible(true);
	famt.setEnabled(false);
	famt.setFont(ff3);
	jpretfine.add(famt);
}


public void resetissue(int ii)
{
int j;
	for(j=0;j<8;j++)
		{
			if(j<=ii)
			{
				tissbid[j].setVisible(true);
				lissbid[j].setVisible(true);
			}
			else
			{
				tissbid[j].setVisible(false);
				lissbid[j].setVisible(false);
			}
		
		}
}



public void warn()
{
//pwarm.removeAll();
finecount();
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
int n=0;
ResultSet rs=st.executeQuery("select count(*) from issue where round(sysdate-iss_date) >= 100 ");
try
{
rs.next();
n=Integer.parseInt(rs.getString("count(*)"));
}
catch(Exception e)
{}
rs=st.executeQuery("select mem_id,bid,iss_date,fine from issue where round(sysdate-iss_date) >= 100 order by fine desc ");
String head[]={"MEMBER_ID","BOOK_ID","ISSUE_DATE","FINE"};
String data[][]=new String[n][4];
int i=0;
while(rs.next())
{

System.out.println(" "+rs.getString("bid")+" :: "+rs.getString("mem_id")+" :: "+rs.getString("fine"));
data[i][0]=rs.getString("mem_id");
data[i][1]=rs.getString("bid");
data[i][2]=rs.getString("iss_date");
data[i][3]=rs.getString("fine");
i++;
}





rs.close();
con.close();
st.close();
JTable jt1=new JTable(data,head);
//jt1.setBackground(Color.white);
Font f=new Font("Arial",Font.BOLD,20);
jt1.setFont(f);
jt1.setEnabled(false);
jt1.setRowHeight(20);
JScrollPane jsp1=new JScrollPane(jt1);

jsp1.setBounds(150,150,600,250);
pwarn.add(jsp1);

}
catch(Exception e)
{System.out.println(e);}


}


public void preturn(JPanel jpret)
{

	int i;
	   
	   
	   retb=new JLabel("Return Book");
       retb.setBounds(250,10,150,100);
      
       tretmid=new JTextField();
       tretmid.setBounds(300,100,200,30);
       lretmid=new JLabel("Member ID");
       lretmid.setBounds(200,100,80,30);
      
		jbretmidok=new JButton("OK");
		jbretmidok.setBounds(550,100,60,30);
		jbretmidok.setActionCommand("rmid ok");
		jbretmidok.addActionListener(this);
        jbretmidok.setFont(f3);
       jbret=new JButton("Conform");
       jbret.setBounds(430,400,130,40);
       jbret.setActionCommand("return ok");
       jbret.addActionListener(this);
	   jbret.setVisible(false);
       jbret.setFont(f3);
       retb.setFont(f);
       lretmid.setFont(f3);
	   
	   
	   
	for(i=0;i<8;i++)
	{
	
	ch[i]=new Checkbox();
	ch[i].setBounds(300,150+i*30,100,30);
	ch[i].setFont(f3);
	ch[i].setVisible(false);
	jpret.add(ch[i]);
	}
	   
	   
	   
      // retno.setFont(f3);
      
       tretmid.setFont(f3);
        jpret.add(jbret);
       jpret.add(retb);
       jpret.add(lretmid);
       jpret.add(tretmid);
       jpret.add(jbretmidok);



}


public void login(JLabel rmp)
{
     
     userlabel=new JLabel("User Name:");
     userlabel.setBounds(350,200,150,40);
	 userlabel.setForeground(Color.white);
	 userlabel.setFont(f);
     passlabel=new JLabel("Password:");
     passlabel.setBounds(350,300,150,40);
	 passlabel.setFont(f);
     passlabel.setForeground(Color.white);
	 loginfield=new JTextField();
     loginfield.setBounds(500,210,200,30);
     loginfield.setFont(f);
     passfield=new JPasswordField();
     passfield.setEchoChar('*');
     passfield.setBounds(500,310,200,30);
     passfield.setFont(f);
     LoginButton=new JButton(new ImageIcon("LOGIN.png"));
     LoginButton.setBounds(450,400,100,30);
	 
     LoginButton.setActionCommand("Login");

     ExitButton=new JButton(new ImageIcon("EXIT.png"));
     //ExitButton.setVisible(true);
     ExitButton.setBounds(600,400,100,30);
     ExitButton.setActionCommand("Exit");
	 
	// LoginAsAdmin=new JButton("Login As Admin");
	// LoginAsAdmin.setBounds(1050,100,250,30);
     
     rmp.add(userlabel);
     rmp.add(passlabel);
     rmp.add(loginfield);
     rmp.add(passfield);
     rmp.add(LoginButton);
     rmp.add(ExitButton);
	// jlg.add(LoginAsAdmin);
     LoginButton.addActionListener(this);
     ExitButton.addActionListener(this);
	// LoginAsAdmin.addActionListener(this);
	 
	 
}


public void issue(JPanel jpissue)
{int i=0,j=0;
String str="issue ",dig;
		jbok=new JButton("ok");
		jbok.setBounds(550,100,50,30);
		jbok.setActionCommand("mid ok");
		jbok.addActionListener(this);
		
       issue=new JLabel("Issue Book");
       issue.setBounds(250,10,150,100);
      /* 
       tissbid1=new JTextField();
       tissbid1.setBounds(300,220,200,30);
       
       tissbid2=new JTextField();
       tissbid2.setBounds(300,280,200,30);
        tissbid3=new JTextField();
       tissbid3.setBounds(300,340,200,30);*/
        tissmid=new JTextField();
       tissmid.setBounds(300,100,200,30);
       lissmid=new JLabel("Member ID");
       lissmid.setBounds(200,100,80,30);
       issno=new JLabel("No of Books");
       issno.setBounds(200,160,100,30);
	   
      /* one=new JRadioButton("1",true);
       two=new JRadioButton("2");
       three=new JRadioButton("3");
       one.setActionCommand("issue 1");  
       two.setActionCommand("issue 2");
       three.setActionCommand("issue 3");
       one.addActionListener(this);
         two.addActionListener(this);
         three.addActionListener(this);
       // four=new JRadioButton("4");
       one.setBounds(300,160,50,30);
       two.setBounds(350,160,50,30);
       three.setBounds(400,160,50,30);
       //four.setBounds(450,160,50,30);
       */
       /*lissbid1=new JLabel("Book ID: 1");
       lissbid1.setBounds(200,220,80,30);
       lissbid2=new JLabel("Book ID: 2");
       lissbid2.setBounds(200,280,80,30);
       lissbid3=new JLabel("Book ID: 3");
       lissbid3.setBounds(200,340,80,30);*/
	   
	   for(i=0;i<8;i++)
	   {
	   str="Book ID: ";
			dig=Integer.toString(i+1);
			str=str+dig;
		lissbid[i]=new JLabel(str);
		lissbid[i].setBounds(200,240+i*30,80,25);
		tissbid[i]=new JTextField();
	   tissbid[i].setBounds(300,240+i*30,200,25);
	   tissbid[i].setFont(f3);
	   lissbid[i].setFont(f3);
	     tissbid[i].setVisible(false);
	   lissbid[i].setVisible(false);
	   jpissue.add(lissbid[i]);
	   jpissue.add(tissbid[i]);
	 
	   
	   }
       
	   bgiss=new ButtonGroup();
      // bgiss.add(one);bgiss.add(two);bgiss.add(three);//bgiss.add(four);
       
	   for(i=0;i<2;i++)
	   {	for(j=0;j<4;j++)
			{str="issue ";
			dig=Integer.toString((i*4)+(j+1));
			str=str+dig;
			if(i==0  && j==0)
			{jrissue[i][j]=new JRadioButton(dig,true);}
			else
			{jrissue[i][j]=new JRadioButton(dig);}
			jrissue[i][j].setActionCommand(str);
			System.out.println(str);
			jrissue[i][j].addActionListener(this);
			jrissue[i][j].setBounds(300+j*50,160+i*40,50,30);
			jrissue[i][j].setVisible(true);
			bgiss.add(jrissue[i][j]);
			jrissue[i][j].setVisible(false);
			jpissue.add(jrissue[i][j]);
			}
	   }
	   
	
	   
       jbiss=new JButton("conform");
       jbiss.setBounds(500,500,150,40);
       jbiss.setActionCommand("issue ok");
       jbiss.addActionListener(this);
		   issno.setVisible(false);
		   jbiss.setVisible(false);
	jbiss.setFont(f3);jbok.setFont(f3);
       issue.setFont(f);
       issno.setFont(f3);
       lissmid.setFont(f3);
       //lissbid1.setFont(f3);lissbid2.setFont(f3);lissbid3.setFont(f3);
       tissmid.setFont(f3);
       //tissbid1.setFont(f3);tissbid2.setFont(f3);tissbid3.setFont(f3);
       
	   //one.setVisible(false);two.setVisible(false);three.setVisible(false);
	   //lissbid1.setVisible(false);lissbid2.setVisible(false);lissbid3.setVisible(false);
       //tissbid1.setVisible(false);tissbid2.setVisible(false);tissbid3.setVisible(false);
       //jbiss.setVisible(true);
	   
	   //jpissue.add(one);jpissue.add(two);jpissue.add(three);//jpissue.add(four);
       jpissue.add(issno);
       jpissue.add(jbiss);jpissue.add(jbok);
       jpissue.add(issue);
       //jpissue.add(lissbid1);jpissue.add(lissbid2);jpissue.add(lissbid3);
       jpissue.add(lissmid);
       jpissue.add(tissmid);
       //jpissue.add(tissbid1);jpissue.add(tissbid2);jpissue.add(tissbid3);
      
	   
	   //addissue(jpissue);

}

public void issueclear(JPanel jpissue)
{
int j;
 issno.setVisible(false);
 jbiss.setVisible(false);
tissmid.setText("");
for(j=0;j<8;j++)
		{
				tissbid[j].setText("");
			
		}

//one.setSelected(true);
// lissbid2.setVisible(false);lissbid3.setVisible(false);
 //      tissbid2.setVisible(false);tissbid3.setVisible(false); 
//tissbid1.setText("");
//tissbid2.setText("");
//tissbid3.setText("");
//tissmid.setText("");
}



	
public void returnconform(String st,int no)	
{
int i,bid,j=1,fine,totalfine=0;
String ss;
boolean b;
ss=nameTOid(st);
System.out.println("NO>>>"+no);
	for(i=0;i<no;i++)
	{
	b=ch[i].getState();
		if(b)
		{
		// ftitle,fmn,fmname,fmi,fmid,fbkdetail[][],ftotal;
		bid=Integer.parseInt(ch[i].getLabel());
		fbkdetail[j][0].setText(ch[i].getLabel());
		System.out.println(">>>>>"+bid);
		//insrecord(bid,st);
	
		fine=returnbook(st,bid);
		fbkdetail[j][1].setText(Integer.toString(fine));
		totalfine+=fine;
		fbkdetail[j][0].setVisible(true);
		fbkdetail[j][1].setVisible(true);
		j++;
		}
	}
	fmname.setText(ss);
	fmid.setText(st);
	famt.setText(Integer.toString(totalfine));

	for(;j<9;j++)
	{
	fbkdetail[j][0].setVisible(false);
	fbkdetail[j][1].setVisible(false);
	}
}

	
public void insrecord(int bid,String sst)	
{
int fine=0,fn=0;
String iss=null;
int mid=Integer.parseInt(sst);
try
	{
	Class.forName(classname);
	Connection con=DriverManager.getConnection(url,username,passwd);
	Statement st=con.createStatement();
	ResultSet rs;
	//ss=issdate(bid,mid);

	 rs=st.executeQuery("select to_date(iss_date) from issue where mem_id="+mid+" and bid="+bid+"");
		
		rs.next();
		try
		{
		iss=rs.getString("to_date(iss_date)");
		}
		catch(Exception e)
		{}
		
	iss=iss.substring(0,10);
	//StringTokenizer s2=new StringTokenizer(iss,"-");
	//iss=null;
	//iss=s2.nextToken();
	//while(s2.hasMoreTokens())
	//{
	//iss=s2.nextToken()+"-"+iss;
	//}
	//fine=fineofbook(bid,mid);	
	
		rs=st.executeQuery("select fine from issue where mem_id="+mid+" and bid="+bid+"");
		
		rs.next();
		try
		{
		fn=Integer.parseInt(rs.getString("fine"));
		}
		catch(Exception e)
		{}
	
	
//	System.out.println(" "+ss+"  "+fn+"  ");
	st.executeQuery(" insert into record values ("+bid+","+mid+",'"+iss+"',sysdate,"+fn+") ");

	rs.close();
	st.close();
	con.close();
	} 
catch(Exception e)
	{
	System.out.println("insrecord:"+e);
	}	
}	
	

public String issdate(int bid,int mid)
{

String isu,iss=null;
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select to_date(iss_date,'dd-mon-yy') from issue where mem_id="+mid+" and bid="+bid+"");
		
		rs.next();
		try
		{
		iss=rs.getString("to_date(iss_date,'dd-mon-yy')");
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();		

	}
	catch(Exception e)
	{
	System.out.println("issdate:"+e);
	}
	iss=iss.substring(0,10);
	StringTokenizer s2=new StringTokenizer(iss,"-");
	iss=null;
	iss=s2.nextToken();
	while(s2.hasMoreTokens())
	{
	iss=s2.nextToken()+"-"+iss;
	}
return iss;
}



public int fineofbook(int bid,int mid)
{
int fn=0;
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select fine from issue where mem_id="+mid+" and bid="+bid+"");
		
		rs.next();
		try
		{
		fn=Integer.parseInt(rs.getString("fine"));
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();	
		
	}
	catch(Exception e)
	{
	System.out.println("fineofbook:"+e);
	}
return fn;
}


public String nameTOid(String sst)
{

int id=Integer.parseInt(sst);
String ss=null;
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select name from member where mem_id="+id+"");
		
		rs.next();
		try
		{
		ss=rs.getString("name");
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();		
		
	}
	catch(Exception e)
	{
	}
return ss;
}


	
public int returnbook(String sst,int bid)
{
int mid,f=0;
mid=Integer.parseInt(sst);
try
	{
	Class.forName(classname);
	Connection con=DriverManager.getConnection(url,username,passwd);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from issue");
	try{
	st.executeUpdate(" update book set noofbk=noofbk+1,availibility='Y' where bid="+bid+" ");
	}
	catch(Exception e){System.out.println("AAAA"+e);}
	try
	{
	rs=st.executeQuery("select fine from issue where bid="+bid+" and mem_id="+mid+" ");
		rs.next();
		try
		{f=Integer.parseInt(rs.getString("fine"));}
		catch(Exception e)
		{System.out.println("fine exc :: "+e);}
	}
	catch(Exception e)
		{System.out.println("AAAAA"+e);}	
	System.out.println(f);
	try
	{
	st.executeUpdate("delete from issue where bid="+bid+" and mem_id="+mid+" ");
	}
	catch(Exception e)
	{System.out.println("AAAAAA"+e);}
	rs.close();
	st.close();
	con.close();
	return f;
	} 
catch(Exception e)
	{
	System.out.println("RETURNBOOK>>>>"+e);
	}

return f;
}	
		



public void register(JPanel jmp)
{

   jreg=new JLabel("Registration");
    jln=new JLabel(" Name ");
    jla=new JLabel("Address");
    jld=new JLabel("Department");
    jlphone=new JLabel("Phone no:");
    jlmail=new JLabel("E-Mail ID");
    jlm=new JLabel("Member Status");
     
    jreg.setBounds(250,10,150,40);
    jln.setBounds(200,80,80,25);
    jld.setBounds(200,140,120,25);
    jlm.setBounds(200,200,120,25);
    jlphone.setBounds(200,260,120,25);
    jlmail.setBounds(200,320,120,25);
    jla.setBounds(200,380,80,25);
    jreg.setFont(f);
    jln.setFont(f3);jlphone.setFont(f3);
    jlmail.setFont(f3);
    jld.setFont(f3); jla.setFont(f3); jlm.setFont(f3); 
    
   
    
    jmid=new JTextField();
    jmid.setBounds(350,80,300,25);
    jmname=new JTextField();
    jmname.setBounds(350,80,300,25);
    jmdept=new JTextField();
    jmdept.setBounds(350,140,300,25);
    jmphone=new JTextField();
    jmphone.setBounds(350,260,300,25);
    jmmail=new JTextField();
    jmmail.setBounds(350,320,300,25);
    jmid.setFont(f3);
    jmname.setFont(f3);
    jmdept.setFont(f3);
    jmphone.setFont(f3);
    jmmail.setFont(f3);
    rs=new JRadioButton("Student",true); c=1;
    rt=new JRadioButton("Teacher");
    
    rs.setBounds(350,200,100,40);
    rt.setBounds(450,200,100,40);
    rs.setFont(f3);rt.setFont(f3);
    bg=new ButtonGroup();
rs.addActionListener(this);
rt.addActionListener(this);
  
    bg.add(rs);
    bg.add(rt);
    jmadd=new TextArea();
    jmadd.setBounds(350,380,300,100);
    
 
    jmem=new JButton("Sign Up");
    jmem.setBounds(500,510,150,40);
	jmem.addActionListener(this);
    jmem.setVisible(true);
    jmem.setFont(f);

	 
	    jmp.add(jmem);
    jmp.add(jla);jmp.add(jld);jmp.add(jreg);jmp.add(jln);jmp.add(jlm);
    jmp.add(jmmail);jmp.add(jmphone);jmp.add(jlphone);jmp.add(jlmail);
    jmp.add(jmname);jmp.add(jmdept);//jmp.add(bg);//
    jmp.add(rs);jmp.add(rt);
    jmp.add(jmadd);
    
    



}

public void detail()
{
    jln1=new JLabel(" Name ");
    jla1=new JLabel("Address");
    jld1=new JLabel("Department");
    jlphone1=new JLabel("Phone no:");
    jlmail1=new JLabel("E-Mail ID");
    jlm1=new JLabel("Member Status");
    
    jln1.setBounds(200,80,80,25);
    jld1.setBounds(200,140,120,25);
    jlm1.setBounds(200,200,120,25);
    jlphone1.setBounds(200,260,120,25);
    jlmail1.setBounds(200,320,120,25);
    jla1.setBounds(200,380,80,25);
    
    jln1.setFont(f3);jlphone1.setFont(f3);
    jlmail1.setFont(f3);
    jld1.setFont(f3); jla1.setFont(f3); jlm1.setFont(f3); 
    
    jmid1=new JTextField();
    jmid1.setBounds(350,80,300,25);
    jmname1=new JTextField();
    jmname1.setBounds(350,80,300,25);
    jmdept1=new JTextField();
    jmdept1.setBounds(350,140,300,25);
    jmphone1=new JTextField();
    jmphone1.setBounds(350,260,300,25);
    jmmail1=new JTextField();
    jmmail1.setBounds(350,320,300,25);
    jmadd1=new TextArea();
    jmadd1.setBounds(350,380,300,100);
    user_status=new JTextField();
    user_status.setBounds(350,200,300,25);
    
    detail_ok=new JButton("OK");
    detail_ok.setBounds(500,510,150,40);
    detail_ok.setActionCommand("detail_ok");
    detail_ok.addActionListener(this);
	   
    
    jmid.setFont(f3);
    jmname.setFont(f3);
    jmdept.setFont(f3);
    jmphone.setFont(f3);
    jmmail.setFont(f3);
    jmadd.setFont(f3);
    
    user_detail2.add(jln1); 
    user_detail2.add(jla1); 
    user_detail2.add(jld1); 
    user_detail2.add(jlphone1); 
    user_detail2.add(jlmail1); 
    user_detail2.add(jlm1);
    user_detail2.add(detail_ok);
    
    user_detail2.add(jmid1); jmid1.setEnabled(false); 
    user_detail2.add(jmname1); jmname1.setEnabled(false);
    user_detail2.add(jmdept1); jmdept1.setEnabled(false);
    user_detail2.add(jmphone1); jmphone1.setEnabled(false);
    user_detail2.add(jmmail1); jmmail1.setEnabled(false);
    user_detail2.add(jmadd1); jmadd1.setEnabled(false);
    user_detail2.add(user_status);  user_status.setEnabled(false);
    
    
    
   //user_insdetail(s); 
    
    


}

void user_insdetail(String s)
{
Connection con;
Statement st;
ResultSet rs;
try
{
Long l=Long.parseLong(s);
Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		st=con.createStatement();
		rs=st.executeQuery("select * from member where mem_id="+l+"");
		rs.next();
		//jmid.setText(rs.getString("mem_id"));
		jmname1.setText(rs.getString("name"));
		jmdept1.setText(rs.getString("dept"));
		jmphone1.setText(rs.getString("phno"));
		jmmail1.setText(rs.getString("email"));
		jmadd1.setText(rs.getString("addr"));
		if(Integer.parseInt(rs.getString("cid"))==1)
		{
		user_status.setText("Student");
		}
		else
		{
		user_status.setText("Teacher");
		}
rs.close();
st.close();
con.close();

		}
catch(Exception e)
{System.out.println(e);}

}

public void issuebook(String st1,String bk)
{
int sst,bbk=0,ccid;
sst=Integer.parseInt(st1);
bbk=Integer.parseInt(bk);
try
	{}
catch(Exception e)
	{}
try
	{
	Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		//ResultSet rs;
		st.executeUpdate("update book set noofbk=noofbk-1 where bid="+bbk+" ");
		st.executeUpdate("update book set availibility='N' where bid="+bbk+" and noofbk=0 ");
		
		ccid=cidTOmid(sst);

		st.executeUpdate("insert into issue values("+bbk+","+sst+","+ccid+",sysdate,null,0)");
		
		
		//insertissue(bk,st1);
		
		//rs.close();
		st.close();
		con.close();
	
	}
catch(Exception e)
	{
	System.out.println("issue book "+e);
	}
}


public void removecheckbox()
{
int i=0;
for(i=0;i<8;i++)
	{
	//ch[i].setVisible(false);
	jpret.remove(ch[i]);
	}
}


public void showcheckbox(int no,int bid[])
{
int i=0;
	for(i=0;i<no;i++)
	{
	ch[i]=new Checkbox(Integer.toString(bid[i]));
	ch[i].setBounds(300,150+i*30,100,30);
	ch[i].setFont(f3);
	jpret.add(ch[i]);
	}
}


public void getbid(String ss,int bid[])
{
int iss=0,id,i;
	
	id=Integer.parseInt(ss);
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs;		
		 rs=st.executeQuery("select bid from issue where mem_id="+id+" ");
		iss=0;
		i=0;
		while(rs.next())
		{
		bid[i]=rs.getInt("bid");
		System.out.println(bid[i]);
		i++;
		}
		
		rs.close();
		st.close();
		con.close();		
		
	}
	catch(Exception e)
	{

	}


}



public int noofissuebook(String ss)
{
int iss=0,id;
	
	try
	{id=Integer.parseInt(ss);
	
	
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs;		
		 rs=st.executeQuery("select count(*) from issue where mem_id="+id+"");
		iss=0;
		rs.next();
		try
		{
		iss=Integer.parseInt(rs.getString("count(*)"));
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();		
		
	}
	catch(Exception e)
	{
System.out.println("noofissuebook  :"+e);
	}
System.out.println(" ::::"+iss+"::::");
return iss;
}






public void insertissue(String bk,String st1)
{
int sst,bbk,ccid;
sst=Integer.parseInt(st1);
bbk=Integer.parseInt(bk);
ccid=cidTOmid(sst);
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		st.executeUpdate("insert into issue values("+bbk+","+sst+","+ccid+",sysdate,null,0)");
		
		st.close();
		con.close();
			
	}
catch(Exception e)
	{
	System.out.println("insertissue :"+e);
	}
}

public boolean bookissued(String s,String mid)
{
int tem,mmid,i=0;
try
	{
		tem=Integer.parseInt(s);
		mmid=Integer.parseInt(mid);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from issue where bid="+tem+" and mem_id="+mmid+" ");
		rs.next();
		try
		{
		i=Integer.parseInt(rs.getString("count(*)"));
		}
		catch(Exception e)
		{
//		JOptionPane.showMessageDialog(jpissue,"Book id does not exists....","Error",0);
//		System.out.println(" book id does not exists....");
		}
		rs.close();
		st.close();
		con.close();
		
		if(i != 0)
		{return true;}
		else
		{return false;}
		
	}
catch(Exception e)
	{	
//	JOptionPane.showMessageDialog(jpissue,"Book id does not exists....","Error",0);
		
	System.out.println("AVAILABLE: "+e);
	}

return false;
}


public boolean available(String s)
{
int tem,i=0;
try
	{
		tem=Integer.parseInt(s);

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select noofbk from book where bid="+tem+" ");
		rs.next();
		try
		{
		i=Integer.parseInt(rs.getString("noofbk"));
		}
		catch(Exception e)
		{
//		JOptionPane.showMessageDialog(jpissue,"Book id does not exists....","Error",0);
//		System.out.println(" book id does not exists....");
		}
		rs.close();
		st.close();
		con.close();
		
		if(i != 0)
		{return true;}
		else
		{return false;}
		
	}
catch(Exception e)
	{	
//	JOptionPane.showMessageDialog(jpissue,"Book id does not exists....","Error",0);
		
	System.out.println("AVAILABLE: "+e);
	}

return false;	
}


public int noofbook(String ss)
{
int no=0,cd,iss,caniss,id;
	
	id=Integer.parseInt(ss);
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs;
		cd=cidTOmid(id);
		
		caniss=noofbooksTOcid(cd);
		 rs=st.executeQuery("select count(*) from issue where mem_id="+id+"");
		iss=0;
		rs.next();
		iss=Integer.parseInt(rs.getString("count(*)"));
		rs.close();
		st.close();
		con.close();		
		no=caniss-iss;
	}
	catch(Exception e)
	{
	System.out.println("cid to mid "+e);
	}
System.out.println(" ::::"+no+"::::");
return no;
}


public int noofbooksTOcid(int cd)
{
int caniss=0;
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select no_books from category where cid="+cd+"");
		caniss=0;
		rs.next();
		try
		{
		caniss=Integer.parseInt(rs.getString("no_books"));
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();		
		return caniss;
	}
	catch(Exception e)
	{
	}
return caniss;
}

public void resetreturn()
{
int i;
tretmid.setText("");
for(i=0;i<8;i++)
	{
	ch[i].setVisible(false);
	}
 jbret.setVisible(false);
	
}

public int cidTOmid(int id)
{
int cd=0;
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select cid from member where mem_id="+id+"");
		cd=0;
		rs.next();
		try
		{
		cd=Integer.parseInt(rs.getString("cid"));
		}
		catch(Exception e)
		{}
		rs.close();
		st.close();
		con.close();		
		return cd;
	}
	catch(Exception e)
	{
	}
return cd;
}



public boolean midcheck(String s)
{
	int id=0;
	try
	{
	id=Integer.parseInt(s);
	}
	catch(Exception e)
	{
	System.out.println("mem id must be digit");
	return false;
	}
	int ch;
	try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from member where mem_id="+id+"");
		ch=0;
		rs.next();
		ch=Integer.parseInt(rs.getString("count(*)"));
		rs.close();
		st.close();
		con.close();		
		if(ch==1)
		{return true;}
		else
		{return false;}
	}
	catch(Exception e)
	{

	}
	return false;
}

public int maxbookissue()
{
int ch;
try
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select max(no_books) from category");
		ch=0;
		rs.next();
		ch=Integer.parseInt(rs.getString("max(no_books)"));
		rs.close();
		st.close();
		con.close();
		return ch;
	}
catch(Exception e)
{

}
return 0;
}


public void insCat()
{
int cc=0,cf=0;
	try
	{
	Class.forName(classname);
	Connection con=DriverManager.getConnection(url,username,passwd);
	Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select count(*) from category");
		rs.next();
		try
		{
		cc=Integer.parseInt(rs.getString("count(*)"));
		System.out.println(cc);
		}
		catch(Exception e)
		{
		System.out.println(e);
		
		}
		
		if(cc==0)
		{
		st.executeQuery("insert into category values(1,'student',2,30)");
		st.executeQuery("insert into category values(2,'teacher',6,150)");
		}
		 rs=st.executeQuery("select count(*) from fine");
		rs.next();
		try
		{
		cf=Integer.parseInt(rs.getString("count(*)"));
		System.out.println(cf);
		}
		catch(Exception e)
		{
		System.out.println(e);
		
		}
		if(cf==0)
		{
		st.executeQuery("insert into fine values(1,7,1)");
		st.executeQuery("insert into fine values(2,7,5)");
		st.executeQuery("insert into fine values(3,0,10)");
		}
		
		st.close();
		con.close();
	}
	catch(Exception e)
	{System.out.println(e);}
}



public void tabledefault()
{
try
{
Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
		Statement st=con.createStatement();
		st.executeQuery("insert into category values(1,'student',2,30)");
		st.executeQuery("insert into category values(2,'teacher',6,150)");
		st.executeQuery("insert into fine values(7,1)");
		st.executeQuery("insert into fine values(7,5)");
		st.executeQuery("insert into fine values(0,10)");
		
		st.close();
		con.close();
}
catch(Exception e)
{}
}

public void tablecreate()
{
 try
{
Class.forName("oracle.jdbc.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","library","library");
Statement st=con.createStatement();
            try
            {
st.execute("create table publisher(pid number(8) constraint pk_pid primary key,pname varchar2(30),paddress varchar2(100))");
            }
            catch(Exception e)
            {
System.out.println(e);                
            }
            try
            {
st.execute("create table book(bid number(8) constraint ok_bid primary key,title varchar2(50) constraint nn_tt not null,author varchar2(20),price number(4),availibility varchar2(3),noOfBk number(3),pid number(3),constraint fk_pid foreign key(pid) references publisher on delete cascade )");             
           }
            catch(Exception e)
            {
                System.out.println(e);
            }
            try
            {
 st.execute("create table category(cid number(8) constraint pk_cid primary key,ctype varchar2(10),no_books number(2),duration number(3))");               
            }
            catch(Exception e)
            {
                
              System.out.println(e);  
            }
            try
            {
 st.execute("create table fine(idx number(3),duration number(3),amt number(3))");               
            }
            catch(Exception e)
            {
               System.out.println(e); 
            }
            try
            {
st.execute("create table librarian(lib_id varchar2(20) constraint pk_lid primary key,password varchar2(20) constraint nn_pass not null)");                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            try
            {
st.execute("create table member(mem_id number(8),cid number(8),name varchar2(20),addr varchar2(100),dept varchar2(20),phno number(13),email varchar2(30),constraint fk_cid foreign key(cid) references category on delete cascade,constraint pk_mem_cid primary key (mem_id,cid))");
                
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            try
            {
st.execute("create table issue(bid number(8),mem_id number(8),cid number(8),iss_date date,ret_date date,fine number(4),constraint fk_bid foreign key(bid) references book(bid) on delete cascade,constraint fk_mid foreign key(mem_id,cid) references member(mem_id,cid) on delete cascade,constraint pk_bid_mem_id_ret_id primary key(bid,mem_id,cid))");                
            }
            catch(Exception e)
            {
              System.out.println(e);  
            }
 try
            {
st.execute("create table history(bid number(8),mem_id number(8),iss_date varchar(15),ret_date date,fine number(4))");                
            }
            catch(Exception e)
            {
              System.out.println(e);  
            }

try
            {
st.execute("create or replace trigger trg1 before delete on issue for each row declare begin insert into history values(:old.bid,:old.mem_id,:old.iss_date,sysdate,:old.fine); end trg1; ");                
            }
            catch(Exception e)
            {
              System.out.println("trigger: "+e);  
            }


st.close();
con.close();

}
catch(Exception e)
{  }

return;
}


public boolean insMem()
{

boolean b=true;
String ss="";
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select mem_id from member");
String tname=jmname.getText();
String tadd=jmadd.getText();
String tdept=jmdept.getText();
String tmail=jmmail.getText();
Long tno;

if(tname.equals(""))
{b=false;
ss+=" Name ";
}	
if(tadd.equals(""))
{b=false;
ss+=" Address ";
}	
if(tdept.equals(""))
{b=false;
ss+=" Dept. ";
}	
if(tmail.equals(""))
{b=false;
ss+=" Mail ";
}

if(!b)
{
JOptionPane.showMessageDialog(jmp," Required field "+ss+" Missing","ERROR...",0);
}	
try
{
tno=Long.parseLong(jmphone.getText());
if(Long.toString(tno).length()!=10)
{
JOptionPane.showMessageDialog(jmp,"Phone no invalid..","ERROR...",0);
jmphone.setText("");
return false;
}

}
catch(Exception e)
{
JOptionPane.showMessageDialog(jmp,"Phone no must be Numeric..","ERROR...",0);
jmphone.setText("");
return false;
}

if(!b)
{
return b;
}

long f=1;
while(rs.next())
{
if(((Long.parseLong(rs.getString("mem_id"))/10000)-1110)==c)
{ f++; }
}
long mem=11100000+(c*10000)+f;

			try
			{	
			
			st.executeUpdate("insert into member values("+mem+","+c+",'"+tname+"','"+tadd+"','"+tdept+"',"+tno+",'"+tmail+"')");
			JOptionPane.showMessageDialog(jmp,"Your Member ID is "+mem+"","Successfully Registered...",1);
			
			}
			catch(Exception e)
			{
			b=false;
			System.out.println("asdfg"+e);
			}

rs.close();
st.close();
con.close();
}
catch(Exception e)
{}
return b;
}

public void insBooknPub2()
{
boolean b=check(jbn.getText(),jau.getText());
System.out.println("ins"+b);

if(b)
{
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
int tno=Integer.parseInt(jno.getText());
st.executeUpdate("update book set noofbk=noofbk+"+tno+" where title='"+jbn.getText()+"' and author='"+jau.getText()+"'");	
flag1=1;	
JOptionPane.showMessageDialog(jpb,"stock updated...","Successful",1);
//rs.close();
st.close();
con.close();
}
catch(Exception e)
{
flag1=0;
JOptionPane.showMessageDialog(jpb,"No. Of Book must be Numeric...","Error",0);
}
}
else
{
JOptionPane.showMessageDialog(jpb,"Entered Values Invalid...","ERROR...",0);
}
}

public void insBooknPub()
{
try
{
Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
ResultSet rs1=st.executeQuery("select pid,pname from publisher");
String tbname=jbn.getText();
String tau=jau.getText();
long tpr=0;
int tno=0;
int flag=0;



try
{
tpr=Long.parseLong(jpr.getText());
}
catch(Exception e)
{
JOptionPane.showMessageDialog(jpb,"Price must be Numeric...!!!","Error",0);
jpr.setText("");
flag=1;
}
try
{
tno=Integer.parseInt(jno.getText());
}
catch(Exception e)
{
JOptionPane.showMessageDialog(jpb,"No. of book must be Numeric...!!!","Error",0);
jno.setText("");
flag=1;
}
String tpname=jpn.getText();
String tadd=jta.getText();
long f,fl=0;                                                                
int tpid=1,tot=1;
long tbid=0;

//System.out.println(rs1.next());

while(rs1.next())
{
tot++;
System.out.println(tot);
	if(tpname.equals(rs1.getString("pname")))
	{  fl=1;
		tpid=Integer.parseInt(rs1.getString("pid"));
	}
}

ResultSet rs=st.executeQuery("select pid from book");
f=1;


while(rs.next())
{
System.out.println(f);
	if(tpid==Integer.parseInt(rs.getString("pid")))
	{f++;}
}
System.out.println(tot);
if(fl==0)
{ tpid=tot; 
  tbid=20000000+(tpid*10000)+1;

		try
		{
if(!jbn.getText().equals("") && !jau.getText().equals("") && !jpr.getText().equals("") && !jno.getText().equals("") && !jpn.getText().equals("") && !jta.getText().equals("") && flag!=1)
{		
	st.executeUpdate("insert into publisher values("+tpid+",'"+tpname+"','"+tadd+"')");
	flag1=1;
}
else
{//JOptionPane.showMessageDialog(jpb,"Required values Missing...!!!","Error",0);
}
	}
		catch(Exception e)
		{
		System.out.println("A :: "+e);
		
		}
		try
		{
if(!jbn.getText().equals("") && !jau.getText().equals("") && !jpr.getText().equals("") && !jno.getText().equals("") && !jpn.getText().equals("") && !jta.getText().equals("") && flag!=1)
{
		st.executeUpdate("insert into book values("+tbid+",'"+tbname+"','"+tau+"',"+tpr+",'Y',"+tno+","+tpid+")");		

JOptionPane.showMessageDialog(jpb,"Book Entered Library Successfully...!!!","Successful",1);
jbn.setText("");
jau.setText("");
jpr.setText("");
jno.setText("");
jpn.setText("");
jta.setText("");	

flag1=1;
}
else
{JOptionPane.showMessageDialog(jpb,"Required values Missing...!!!","Error",0);
}
		}
		catch(Exception e)
		{
		System.out.println("aaaa"+e);
		}
}
else
{
tbid=20000000+(tpid*10000)+f;
 
		try
		{
if(!jbn.getText().equals("") && !jau.getText().equals("") && !jpr.getText().equals("") && !jno.getText().equals("") && !jpn.getText().equals("") && !jta.getText().equals("") && flag!=1)
{
st.executeUpdate("insert into book values("+tbid+",'"+tbname+"','"+tau+"',"+tpr+",'Y',"+tno+","+tpid+")");		
JOptionPane.showMessageDialog(jpb,"Book Entered Library Successfully...!!!","Successful",1);
jbn.setText("");
jau.setText("");
jpr.setText("");
jno.setText("");
jpn.setText("");
jta.setText("");	
flag1=1;
}
else
{}		
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
}
rs1.close();
rs.close();
con.close();
st.close();

}
catch(Exception e)
{System.out.println(e);}





}


public boolean check(String tbname,String tau)
{
int i=0;
try
{

Class.forName(classname);
Connection con=DriverManager.getConnection(url,username,passwd);
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select count(*) from book where title='"+tbname+"' and author='"+tau+"' ");
rs.next();
i=Integer.parseInt(rs.getString("count(*)"));
rs.close();
st.close();
con.close();

if(i==0)
{return false;}
else
{return true;}
}
catch(Exception e)
{System.out.println("aaa"+e);}
return false;
}

}


public class Library 
{
    public static void main(String[] args)   
    {
    
     book b1=new book("Library");
     b1.setVisible(true);
     
     b1.setBounds(0,0,1360,760);
     b1.setLocation(0,0);
           
     b1.setDefaultCloseOperation(b1.EXIT_ON_CLOSE);
     
    }
}
