<%@ tag language="java" pageEncoding="UTF-8"%>

      <section class="board">
       <h3>상품신청</h3>
       <hr>
	  <div style="padding:40px;">
	  <h4>연어회덮밥${boardList.board_title}</h4>
	  <p style="align:right;">추천 수 : 222${boardList.board_like}</p>
	  <button class="btn button-xs button-like" onclick="location.href='updateBoard.do&board_number=${boardList.board_number}'">나도 추천!</button><br>
	  <hr>
	  <p style="color:black; font-size:18px;">신선한 연어회가 그릇을 가득 덮고 양파가 향을 잡아주는 연어회덮밥.${boardList.board_content}</p>
	  <hr>
	  <p>글 번호 : 글번호${boardList.board_number}</p><p style="align:right;">!!이름${boardList.customer_name}&nbsp;&nbsp;2012.3.22${boardList.board_date}</p>
	  </div>		
      </section>
      
      
만약 내 글 보기라면,
	  <section class="board">
       <h3>상품신청</h3>
       <hr>
	  <div style="padding:40px;">
	  <h4>연어회덮밥${boardList.board_title}</h4>
	  <p style="align:right;">추천 수 : 222${boardList.board_like}</p>
	  <button class="btn button-xs button-like" onclick="location.href='updateBoard.do&board_number=${boardList.board_number}'">나도 추천!</button><br>
	  <hr>
	  <p style="color:black; font-size:18px;">신선한 연어회가 그릇을 가득 덮고 양파가 향을 잡아주는 연어회덮밥.${boardList.board_content}</p>
	  <hr>
	  <p>글 번호 : 글번호${boardList.board_number}</p><p style="align:right;">!!이름${boardList.customer_name}&nbsp;&nbsp;2012.3.22${boardList.board_date}</p>
	  만약 작성자라면<a href="boardDelete.do">글 삭제하기</a>
	  </div>		
      </section>