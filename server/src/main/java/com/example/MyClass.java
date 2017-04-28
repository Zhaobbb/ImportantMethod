package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyClass {

    public static void main(String[] args)
    {

        Gson gson=new GsonBuilder().disableHtmlEscaping().create();
//妙招数据
        String[] imgs={"http://d.5857.com/ctmn_170307/desk_008.jpg","http://d.5857.com/xgs_150428/desk_005.jpg"
                , "http://d.5857.com/jxxg_170309/desk_002.jpg","http://d.5857.com/fmsn_170307/desk_014.jpg" };
        ArrayList<String> hot_idea_data_img=new ArrayList<>();
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493881114&di=e4646fab8013e0e6dba8814522086494&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.bz55.com%2Fuploads%2Fallimg%2F150421%2F139-150421160617.jpg");
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493286395758&di=0dfb6735f7acaaaa581a7dd4c7041408&imgtype=0&src=http%3A%2F%2Fimg2.3lian.com%2F2014%2Ff5%2F15%2Fd%2F17.jpg");
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493286395758&di=9c92a59b260b2a0d654aad65b5ad9a30&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F17%2F62%2F32%2F36I58PICtUY_1024.jpg");
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493286395757&di=5bed61a457c214c0f7c641c538a0fbfe&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F9%2F578842fe886cb.jpg");
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493286395757&di=9b9e914b9375de5e9a570f238eeafada&imgtype=0&src=http%3A%2F%2Fwww.bz55.com%2Fuploads%2Fallimg%2F150116%2F139-150116141212.jpg");
        hot_idea_data_img.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493286395757&di=aca5cfdba04eaba22c0d5add83072f34&imgtype=0&src=http%3A%2F%2Fimg2.3lian.com%2F2014%2Ff5%2F75%2Fd%2F104.jpg");

        ArrayList<String> hot_idea_text=new ArrayList<>();
        hot_idea_text.add("讲好英语的八个小技巧");hot_idea_text.add("海誓山盟变成一种玩笑，谁许谁天荒地老");hot_idea_text.add("谁守护谁亿万年华？经历了漫长的黑夜之后");
        hot_idea_text.add("我终于醒了过来。当清晨的第一缕阳光洒进窗子");hot_idea_text.add("我开始怀疑，漫长的记忆是否只是一场发生在梦里的幻境");hot_idea_text.add("一场繁华，一丝烟雨，一颗珠泪");

        ArrayList<String> hot_idea_provider=new ArrayList<>();
        hot_idea_provider.add("苏菲");hot_idea_provider.add("Ken");hot_idea_provider.add("Ann");
        hot_idea_provider.add("Peter");hot_idea_provider.add("Obama");hot_idea_provider.add("Talor");

        ArrayList<Integer> hot_idea_interestnum=new ArrayList<>();
        hot_idea_interestnum.add(785);hot_idea_interestnum.add(1152);hot_idea_interestnum.add(7890);
        hot_idea_interestnum.add(1120);hot_idea_interestnum.add(985);hot_idea_interestnum.add(211);

        ViewpagerData viewpagerData=new ViewpagerData(imgs);
        ContentData contentData=new ContentData("http://pic2.cxtuku.com/00/09/06/b925af110598.jpg","来自服务器的名字","来自服务器的描述来自服务器的描述");
        Hot_idea_Data hot_idea_data=new Hot_idea_Data(hot_idea_data_img,hot_idea_text,hot_idea_provider,hot_idea_interestnum);

        FirstDataSet firstDataSet=new FirstDataSet(viewpagerData,contentData,hot_idea_data);

       //生成字符串
        String jsonStr=gson.toJson(firstDataSet);




       //攻略数据
        ArrayList<String> method_img=new ArrayList<>();
        method_img.add("http://img2.imgtn.bdimg.com/it/u=545220710,3630816120&fm=11&gp=0.jpg");
        method_img.add("http://img17.3lian.com/d/file/201701/23/5b7a4e82047af50a97c512492eb1e3ae.jpg");
        method_img.add("http://img0.imgtn.bdimg.com/it/u=3103287444,2787333850&fm=23&gp=0.jpg");
        method_img.add("http://c.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3da25bb440b8a1cd11728b2903.jpg");
        method_img.add("http://pic.pp3.cn/uploads/201508/2015082213.jpg");

        ArrayList<String> method_title=new ArrayList<>();
        method_title.add("怎么奔跑也跨不过的青春，只好伸出手道别。");
        method_title.add("因为没得到，所以显得格外好，这不是爱。");
        method_title.add("一厢情愿，就得愿赌服输。");
        method_title.add("世界上唯一不变的就是变化");
        method_title.add("世界上唯一可能的就是不可能");

        ArrayList<Integer> method_sawnum=new ArrayList<>();
        method_sawnum.add(100);
        method_sawnum.add(88);
        method_sawnum.add(256);
        method_sawnum.add(111);
        method_sawnum.add(321);

        ArrayList<Integer> method_likenum=new ArrayList<>();
        method_likenum.add(20);
        method_likenum.add(35);
        method_likenum.add(64);
        method_likenum.add(12);
        method_likenum.add(45);

        MethodData methodData=new MethodData(method_img,method_title,method_sawnum,method_likenum);
        //生成字符串
        String methodStr=gson.toJson(methodData);
//        System.out.println(jsonStr);

        //社区__圈子 first 数据
        ArrayList<String> community_first_head=new ArrayList<>();
        community_first_head.add("http://img0.imgtn.bdimg.com/it/u=3728173095,1820094037&fm=23&gp=0.jpg");
        community_first_head.add("http://img1.imgtn.bdimg.com/it/u=3649068744,3901725653&fm=214&gp=0.jpg");
        community_first_head.add("http://tx.haiqq.com/uploads/allimg/150327/2105502I5-6.jpg");
        community_first_head.add("http://www.qqxoo.com/uploads/allimg/170426/13291U0T-0.jpg");
        community_first_head.add("http://up.qqjia.com/z/01/tu3958_17.jpg");
        community_first_head.add("http://img4.imgtn.bdimg.com/it/u=3881995121,942105441&fm=23&gp=0.jpg");
        community_first_head.add("http://tx.haiqq.com/uploads/allimg/150327/21003532K-0.jpg");
        community_first_head.add("http://www.qq745.com/uploads/allimg/140928/1-14092PRT2-50.jpg");
        community_first_head.add("http://v1.qzone.cc/avatar/201507/04/11/50/5597580321899759.jpg%21200x200.jpg");


        ArrayList<String> community_first_title=new ArrayList<>();
        community_first_title.add("路飞的圈子");
        community_first_title.add("索隆的圈子");
        community_first_title.add("乌索普的圈子");
        community_first_title.add("娜美的圈子");
        community_first_title.add("罗宾的圈子");
        community_first_title.add("香吉士的圈子");
        community_first_title.add("乔巴的圈子");
        community_first_title.add("弗兰奇的圈子");
        community_first_title.add("布鲁克的圈子");


        ArrayList<Integer> community_first_num=new ArrayList<>();
        community_first_num.add(11);
        community_first_num.add(22);
        community_first_num.add(33);
        community_first_num.add(44);
        community_first_num.add(55);
        community_first_num.add(66);
        community_first_num.add(77);
        community_first_num.add(88);
        community_first_num.add(99);


        ArrayList<String> community_first_text=new ArrayList<>();
        community_first_text.add("最美的不是下雨天而是曾与你躲过雨的屋檐。");
        community_first_text.add("当风筝厌倦了天空，是否就会义无反顾地坠入大海?");
        community_first_text.add("过去的真能过去现在的就真的是现在了吗?\n");
        community_first_text.add("假如 我说假如我走了你会流泪会伤心不顾一切的寻找我吗?");
        community_first_text.add("做对的事情比把事情做对重要。");
        community_first_text.add("走过了，错过了。抓住了，失去了。");
        community_first_text.add("真正的满足来自你的内心，而不是外界的人和物。");
        community_first_text.add("手执前世的悲凉，看着今世的忧伤。");
        community_first_text.add("人生是一场错过，愿你别蹉跎。");
        Community_firstData community_firstData=new Community_firstData(community_first_head,community_first_title,
                community_first_num,community_first_text);
//转为JSON字符串
        String FirstStr=gson.toJson(community_firstData);
//        System.out.println(FirstStr);

        //社区 活动  Second 添加数据
        ArrayList<String> community_second_img=new ArrayList<>();
        community_second_img.add("http://img.bizhi.sogou.com/images/2013/09/10/379469.jpg");
        community_second_img.add("http://img2.imgtn.bdimg.com/it/u=3922644044,2897570758&fm=11&gp=0.jpg");

        ArrayList<String> community_second_title=new ArrayList<>();
        community_second_title.add("大爷来玩啊~~~");
        community_second_title.add("告诉别人一件事");

        ArrayList<String> community_second_date=new ArrayList<>();
        community_second_date.add("2017-04-28 15:14");
        community_second_date.add("2017-10-01 12:30");

        ArrayList<String> community_second_address=new ArrayList<>();
        community_second_address.add("北京市延庆区八达岭镇");
        community_second_address.add("海淀区上地七街八维学院");

        ArrayList<String> community_second_price=new ArrayList<>();
        community_second_price.add("¥30");
        community_second_price.add("¥500");

        ArrayList<Integer> community_second_taker=new ArrayList<>();
        community_second_taker.add(111);
        community_second_taker.add(222);

        Community_secondData community_secondData=new Community_secondData(community_second_img,community_second_title
        ,community_second_date,community_second_address,community_second_price,community_second_taker);
//转化为JSON字符串
        String SecondStr=gson.toJson(community_secondData);
//        System.out.println(SecondStr);


        //微课 添加数据  Viewpagerdata + lessondata
        String[] lessonimgs={
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493976257&di=9558860a711335079ac6fc853f3108eb&imgtype=jpg&er=1&src=http%3A%2F%2Fwww.pp3.cn%2Fuploads%2F201607%2F20160704009.jpg"
                ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493381567862&di=3e21261319da5b8203fd58d88fa98065&imgtype=0&src=http%3A%2F%2Fimg5.hao123.com%2Fdata%2F1_82c322796f1a9cd6c0f2027246ed8fc4_510",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493381619767&di=74ab8ddb08a0f5d1f9624e9e7839d5cc&imgtype=0&src=http%3A%2F%2Fwww.bz55.com%2Fuploads%2Fallimg%2F120725%2F1-120H5145217.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493381639287&di=b829e63c9457e373cbff3354a4674a55&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F315%2F41%2F0N23RUHSXR06.jpg"
        };
        ViewpagerData lessonvp=new ViewpagerData(lessonimgs);

        ArrayList<String> lesson_img=new ArrayList<>();
        lesson_img.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1303/18/c1/19021705_1363598763871.jpg");
        lesson_img.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1307/15/c1/23361122_1373881899692.jpg");
        lesson_img.add("http://img0.imgtn.bdimg.com/it/u=415744021,594328793&fm=23&gp=0.jpg");
        lesson_img.add("http://pic1.win4000.com/wallpaper/3/513d3f8e9e728.jpg");
        lesson_img.add("http://img1.imgtn.bdimg.com/it/u=585013194,2826900649&fm=23&gp=0.jpg");
        lesson_img.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1306/04/c0/21643957_1370325500320.jpg");


        ArrayList<String> lesson_title=new ArrayList<>();
        lesson_title.add("辗转一流年，时光穿梭");
        lesson_title.add("岁月如水轻轻地蒸发，光景却是另一番");
        lesson_title.add("光阴积累回忆，时间循环生机");
        lesson_title.add("每一片旖旎的风光，孕育了每一片代表生机的翠绿");
        lesson_title.add("春天里的阳光轻暖如棉，细雨如针");
        lesson_title.add("轻轻落在浅黄的树叶上，深化每一点绿色");



        ArrayList<String> lesson_date=new ArrayList<>();
        lesson_date.add("2017-04-28 17:36");
        lesson_date.add("2017-05-01 12:00");
        lesson_date.add("2017-06-01 06:00");
        lesson_date.add("8888-88-88 88:88");
        lesson_date.add("2018-01-01 00:00");
        lesson_date.add("2012-12-21 12:30");


        ArrayList<String> lesson_price=new ArrayList<>();
        lesson_price.add("¥11");
        lesson_price.add("¥22");
        lesson_price.add("¥33");
        lesson_price.add("¥44");
        lesson_price.add("¥55");
        lesson_price.add("¥66");

        ArrayList<String> lesson_provider=new ArrayList<>();
        lesson_provider.add("Tony");
        lesson_provider.add("Gaga");
        lesson_provider.add("Baby");
        lesson_provider.add("BBQ");
        lesson_provider.add("Huihui");
        lesson_provider.add("Ling");

        ArrayList<Integer> lesson_looker=new ArrayList<>();
        lesson_looker.add(16);
        lesson_looker.add(26);
        lesson_looker.add(87);
        lesson_looker.add(115);
        lesson_looker.add(211);
        lesson_looker.add(985);

        LessonData lessonData=new LessonData(lesson_img,lesson_title,lesson_date,lesson_price,lesson_provider,lesson_looker);
        //转化为JSON字符串
        LessonDataSet lessonDataSet=new LessonDataSet(lessonvp,lessonData);
        String LessonStr=gson.toJson(lessonDataSet);
        System.out.println(LessonStr);



        try {
            ServerSocket server = new ServerSocket(8989);//定义客户端的端口号
            Socket client = server.accept();//定义一个Socket对象

            InputStream is = client.getInputStream();//服务器接受信息输入流，也就是接受从服务器段发送过来的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));//用bufferedreader包装下输入流

            OutputStream os = client.getOutputStream();//这是用来给服务器发送消息的输出流

//            PrintStream ps = new PrintStream(os);
//            Scanner scanner = new Scanner(System.in);//从键盘输入字符串

            boolean flag = true;//定义一个死循环，让服务器不停的接受从客户端发送来的字符串
            while (flag) {
                String s=br.readLine();
                if(s==null){
                    break;
                }


                String[] splits=s.split(" ");
                String string=null;

//                System.out.println(splits[1]);

                if(s.equals("GET /getfirstpage HTTP/1.1")){
                    string="HTTP/1.1 200 OK\nContent-Length: "+jsonStr.getBytes().length+"\n\n"+jsonStr;
                    System.out.println(s);
                    os.write(string.getBytes(), 0, string.getBytes().length);

                    os.flush();
                }

                else if(s.equals("GET /getmethodpage HTTP/1.1")){
                    string="HTTP/1.1 200 OK\nContent-Length: "+methodStr.getBytes().length+"\n\n"+methodStr;
                    System.out.println(s);
                    os.write(string.getBytes(), 0, string.getBytes().length);

                    os.flush();
                }
                else if(s.equals("GET /getmethodfirst HTTP/1.1")){
                    string="HTTP/1.1 200 OK\nContent-Length: "+FirstStr.getBytes().length+"\n\n"+FirstStr;
                    System.out.println(s);
                    os.write(string.getBytes(), 0, string.getBytes().length);

                    os.flush();
                }
                else if(s.equals("GET /getmethodsecond HTTP/1.1")){
                    string="HTTP/1.1 200 OK\nContent-Length: "+SecondStr.getBytes().length+"\n\n"+SecondStr;
                    System.out.println(s);
                    os.write(string.getBytes(), 0, string.getBytes().length);

                    os.flush();
                }
                else if(s.equals("GET /getlesson HTTP/1.1")){
                    string="HTTP/1.1 200 OK\nContent-Length: "+LessonStr.getBytes().length+"\n\n"+LessonStr;
                    System.out.println(s);
                    os.write(string.getBytes(), 0, string.getBytes().length);

                    os.flush();
                }





//                String s2 = scanner.nextLine();//s2是写给客户端的字符串
//                ps.println("123456789");    //给客户端发送你写的东西
            }

            client.close();
        }
        catch (IOException e) {//try 跟catch你不用管，这是用来处理异常的，就是固定格式
            e.printStackTrace();
        }

    }

}
