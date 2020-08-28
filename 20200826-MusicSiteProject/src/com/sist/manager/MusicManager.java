package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.MusicDAO;

/*
 *  <tr class="list" songId="90726458">
    <td class="check"><input type="checkbox" class="select-check" title=" ���� �ƴ� �״� "/>
  <td class="number" list-role="��ȣ">1
    <td><a href="#" class="cover"  onclick="fnViewAlbumLayer(81549860); return false;" ontouchend="fnViewAlbumLayer(81549860); return false;" ><span class="mask"></span><img onerror="this.src='//image.genie.co.kr/imageg/web/common/blank_68.gif';" src="/Y/IMAGE/IMG_ALBUM/081/549/860/81549860_1598338597705_1_140x140.JPG" alt="���� �ƴ� �״�" /></a></td>
    <td class="link"><a href="#" class="btn-basic btn-info" onclick="fnViewSongInfo(90726458); return false;" ontouchend="fnViewSongInfo(90726458); return false;" >�� ���� ���� ������</a></td>
      <td class="info">
           <a href="#" class="title ellipsis" title="���� �ƴ� �״�" onclick="fnPlaySong('90726458;','1'); return false;" ontouchend="fnPlaySong('90726458;','1'); return false;">
���� �ƴ� �״�</a>
            <a href="#" class="artist ellipsis"onclick="fnViewArtist(80635263); return false;" ontouchend="fnViewArtist(80635263); return false;" >�̻��</a>           <div class="toggle-button-box" id="hide-button">
               <button type="button" class="btn artist-etc"onclick="fnRelationArtistList('90726458'); artist_etc_layer._show(this);return false;" ontouchend="fnRelationArtistList('90726458'); artist_etc_layer._show(this);return false;" >��</button>
               <dl class="list" id="RelationArtist_90726458">
               </dl>
           </div>
            <i class="bar">|</i>
            <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer(81549860); return false;" ontouchend="fnViewAlbumLayer(81549860); return false;" >���� �ƴ� �״� (X-MAS Project Special)</a>
        </td>
        
        ����1
        try
        {
                  ����2 ==> error ==> ����
        }catch(Exception ex){}
        ����3
        ����4
        ����5
        
        try
        {
            for(int i=0;i<10;i++)
            {
               try
               {
                  ==
                  ==
                  == error
               }catch(Exception ex){ ==> i++}
            }
        }catch(Exception ex){����}
 */
public class MusicManager {
    public void musicAllData()
    {
    	MusicDAO dao=new MusicDAO();
    	try
    	{
    		int k=1;
    		// for(int i=1;i<=101;i+=50)
    		// https://www.melon.com/genre/song_list.htm?gnrCode=GN0200#params%5BgnrCode%5D=GN0200&params%5BdtlGnrCode%5D=&params%5BorderBy%5D=NEW&params%5BsteadyYn%5D=N&po=pageObj&startIndex="+i
    		for(int i=1;i<=5;i++)
    		{
	    		Document doc=Jsoup.connect("https://www.genie.co.kr/genre/L0207?genreCode=L0207&pg="+i).get();
	    		Elements title=doc.select("td.info a.title");
	    		Elements singer=doc.select("td.info a.artist");
	    		Elements album=doc.select("td.info a.albumtitle");
	    		Elements poster=doc.select("a.cover img");
	    		
	    		for(int j=0;j<title.size();j++)
	    		{
	    			try
	    			{
		    			MusicVO vo=new MusicVO();
		    			System.out.println("��ȣ:"+ k++);
		    			System.out.println("cateno:1");
		    			System.out.println("����:"+title.get(j).text());
		    			System.out.println("������:"+singer.get(j).text());
		    			System.out.println("�ٹ�:"+album.get(j).text());
		    			System.out.println("������:"+poster.get(j).attr("src"));
	    			    System.out.println("==============================");
	    			    // vo�� ���� ä��� => DAO
	    			    vo.setCateno(10);
	    			    vo.setTitle(title.get(j).text());
	    			    vo.setSinger(singer.get(j).text());
	    			    vo.setAlbum(album.get(j).text());
	    			    vo.setPoster(poster.get(j).attr("src"));
	    			    // DAO�� ���� 
	    			    dao.musicInsert(vo);
	    			    Thread.sleep(100);
	    			}catch(Exception ex){}
	    		}
	    		System.out.println("End...");
    		}
    		
    	}catch(Exception ex){}
    }
    public void melonAllData()
    {
    	try
    	{
    		int k=1;
    		// for(int i=1;i<=101;i+=50)
    		// https://www.melon.com/genre/song_list.htm?gnrCode=GN0200#params%5BgnrCode%5D=GN0200&params%5BdtlGnrCode%5D=&params%5BorderBy%5D=NEW&params%5BsteadyYn%5D=N&po=pageObj&startIndex="+i
    		/*
    		 *   <td><div class="wrap">
										<a href="javascript:melon.link.goAlbumDetail('10480453');" title="�ʴ� �ູ������" class="image_typeAll">
											<img onerror="WEBPOCIMG.defaultAlbumImg(this);" width="60" height="60" src="https://cdnimg.melon.co.kr/cm2/album/images/104/80/453/10480453_20200825112915_500.jpg/melon/resize/120/quality/80/optimize" alt="�ʴ� �ູ������ - ������ �̵�"/>
											<span class="bg_album_frame"></span>
										</a>
									</div></td>
									<td><div class="wrap">
										<a href="javascript:melon.link.goSongDetail('32878524');" title="�ʴ� �ູ������ (Feat. �鼱��) ������" class="btn button_icons type03 song_info"><span class="none">������</span></a>
									</div></td>
									<td><div class="wrap">
										<div class="wrap_song_info">
											<div class="ellipsis rank01"><span>
						
												<a href="javascript:melon.play.playSong('25220101',32878524);" title="�ʴ� �ູ������ (Feat. �鼱��) ���">�ʴ� �ູ������ (Feat. �鼱��)</a>
											</span></div><br>
											<div class="ellipsis rank02">
												
												
												<a href="javascript:melon.link.goArtistDetail('424945');" title="���������� - ������ �̵�" >����������</a><span class="checkEllipsis" style="display:none"><a href="javascript:melon.link.goArtistDetail('424945');" title="���������� - ������ �̵�" >����������</a></span>
											</div>
											
										</div>
									</div></td>
									<td><div class="wrap">
										<div class="wrap_song_info">
											<div class="ellipsis rank03">
												<a href="javascript:melon.link.goAlbumDetail('10480453');" title="�ʴ� �ູ������ - ������ �̵�">�ʴ� �ູ������</a>
											</div>
										</div>
									</div></td>
									<td><div class="wrap">
										<button type="button" class="button_etc like" title="�ʴ� �ູ������ (Feat. �鼱��) ���ƿ�" data-song-no="32878524" data-song-menuid="25220101">
											<span class="odd_span">���ƿ�</span>
											<span class="cnt">
												<span class="none">�ѰǼ�</span>
												0
											</span>
										</button>
									</div></td>
    		 */
    		//for(int i=1;i<=101;i+=50)
    		{
    			// https://www.melon.com/genre/song_list.htm?gnrCode=GN0100#params%5BgnrCode%5D=GN0100&params%5BdtlGnrCode%5D=&params%5BorderBy%5D=NEW&params%5BsteadyYn%5D=N&po=pageObj&startIndex=51
	    		Document doc=Jsoup.connect("https://www.melon.com/genre/song_list.htm?gnrCode=GN0100#params%5BgnrCode%5D=GN0100&params%5BdtlGnrCode%5D=&params%5BorderBy%5D=NEW&params%5BsteadyYn%5D=N&po=pageObj&startIndex=51").get();
	    		Elements title=doc.select("div.wrap_song_info div.rank01 a");
	    		Elements singer=doc.select("div.wrap_song_info div.rank02 a:eq(0)");
	    		Elements album=doc.select("div.wrap_song_info div.rank03 a");
	    		Elements poster=doc.select("div.wrap a.image_typeAll img");
	    		int m=1;
	    		for(int j=0;j<title.size();j++)
	    		{
	    			try
	    			{
		    			
		    			System.out.println("��ȣ:"+ k++);
		    			System.out.println("cateno:1");
		    			System.out.println("����:"+title.get(j).text());
		    			System.out.println("������:"+singer.get(m).text());
		    			System.out.println("�ٹ�:"+album.get(j).text());
		    			System.out.println("������:"+poster.get(j).attr("src"));
	    			    System.out.println("==============================");
	    			    // vo�� ���� ä��� => DAO
	    			    m+=2;
	    			}catch(Exception ex){}
	    		}
	    		System.out.println("End...");
    		}
    		
    	}catch(Exception ex){}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MusicManager m=new MusicManager();
        //m.musicAllData();
        m.melonAllData();
	}

}
