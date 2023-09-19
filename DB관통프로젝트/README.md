# README

# 관광지 검색

---

## 1. 관광지 검색(전체)
![7](/uploads/4ad7a6d563ff90dac3596248248dfa3e/7.PNG)

```java
public List<AttractionInfoDto> attractionList(AttractionInfoDto attractionInfoDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AttractionInfoDto> attractionLists = new ArrayList<>();
		try {
			
			StringBuilder sql;
			if (attractionInfoDto.getSidoCode() == 0 && attractionInfoDto.getContentTypeId() == 0) {
				sql = new StringBuilder("select * \n");
				sql.append("from attraction_info \n");
			}
			else if(attractionInfoDto.getSidoCode() == 0) {
				sql = new StringBuilder("select * \n");
				sql.append("from attraction_info \n");
				sql.append("where content_type_id = " + attractionInfoDto.getContentTypeId());
				
			}else {
				sql = new StringBuilder("select * \n");
				sql.append("from attraction_info \n");
				sql.append("where sido_code = " + attractionInfoDto.getSidoCode());
					
			}
			//sql.append("order by content_id limit 0, 20");
			conn = DBUtil.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AttractionInfoDto entity = new AttractionInfoDto();
				entity.setContentId(rs.getInt("content_id"));
				entity.setContentTypeId(rs.getInt("content_type_id"));
				entity.setTitle(rs.getString("title"));
				entity.setAddr1(rs.getString("addr1"));
				entity.setAddr2(rs.getString("addr2"));
				entity.setZipcode(rs.getString("zipcode"));
				entity.setTel(rs.getString("tel"));
				entity.setFirstImage(rs.getString("first_image"));
				entity.setFirstImage2(rs.getString("first_image2"));
				entity.setReadcount(rs.getInt("readcount"));
				entity.setSidoCode(rs.getInt("sido_code"));
				entity.setGugunCode(rs.getInt("gugun_code"));
				entity.setLatitude(rs.getDouble("latitude"));
				entity.setLongitude(rs.getDouble("longitude"));
				entity.setMlevel(rs.getString("mlevel"));
				attractionLists.add(entity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return attractionLists;
	}
```

## 2. 관광지 검색(관광지 명)
![8](/uploads/e2b43f444b582453535187d52d6e052a/8.PNG)

```java
@Override
	public List<AttractionInfoDto> searchByTitle(String title, int sidoCode) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AttractionInfoDto> attractionLists = new ArrayList<>();
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from attraction_info \n");
			sql.append("where title like \"%" + title +"%\" and sido_code = " + sidoCode);
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AttractionInfoDto entity = new AttractionInfoDto();
				entity.setContentId(rs.getInt("content_id"));
				entity.setContentTypeId(rs.getInt("content_type_id"));
				entity.setTitle(rs.getString("title"));
				entity.setAddr1(rs.getString("addr1"));
				entity.setAddr2(rs.getString("addr2"));
				entity.setZipcode(rs.getString("zipcode"));
				entity.setTel(rs.getString("tel"));
				entity.setFirstImage(rs.getString("first_image"));
				entity.setFirstImage2(rs.getString("first_image2"));
				entity.setReadcount(rs.getInt("readcount"));
				entity.setSidoCode(rs.getInt("sido_code"));
				entity.setGugunCode(rs.getInt("gugun_code"));
				entity.setLatitude(rs.getDouble("latitude"));
				entity.setLongitude(rs.getDouble("longitude"));
				entity.setMlevel(rs.getString("mlevel"));
				attractionLists.add(entity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return attractionLists;
	}
```

# 유저 등록, 로그인, 수정 삭제

---

## 1. 등록
![9](/uploads/70b2b33e54e4edf3eb3fa28644a114be/9.PNG)
```java
public void registerMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into member(user_id, user_name, user_password, join_date)\n");
			sql.append("values( ?, ?, ?, sysdate())");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, memberDto.getUserId());
			pstmt.setString(2, memberDto.getUserName());
			pstmt.setString(3, memberDto.getUserPass());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(pstmt,conn);
		}
	}
```

## 2. 로그인
![10](/uploads/a2bb8f2902faa7ae9cedeb7495182980/10.PNG)
```java
public MemberDto login(String userId, String userPass) {
		MemberDto memberdto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "SELECT * \r\n" + "FROM member \r\n" + 
			"WHERE user_id = "+ "'"+ userId+ "' AND user_password = '" + userPass+ "';" ;
			pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                String ruserId = rs.getString("user_id");
                String username = rs.getString("user_name");
                String userpassword = rs.getString("user_password");
                java.sql.Timestamp joindate = rs.getTimestamp("join_date");
                
                memberdto = new MemberDto(ruserId,username,userpassword,joindate.toString());
                
            }
            if (rowCount == 1) {
            	return memberdto;
            }else
            {
            	return null;
            }
            
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(pstmt,conn);
		}
		
		// TODO Auto-generated method stub
		return null;
	}
```

## 3. 수정
![11](/uploads/6bd81834369e7701ed0cf109d8ef9529/11.PNG)

```java
public void modifyMember(MemberDto memberDto) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = DBUtil.getInstance().getConnection();
	        String sql = "UPDATE member SET user_name = ?, user_password = ? WHERE user_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, memberDto.getUserName());
	        pstmt.setString(2, memberDto.getUserPass());
	        pstmt.setString(3, memberDto.getUserId());
	        
	        int rowCount = pstmt.executeUpdate();
	        
	        if (rowCount == 1) {
	            System.out.println("회원 정보가 수정되었습니다.");
	        } else {
	            System.out.println("회원 정보 수정에 실패했습니다.");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.getInstance().close(pstmt, conn);
	    }
	}
```

## 4. 삭제
![12](/uploads/d7aedc676731e1edac8b4cf35e1732ab/12.PNG)
```java
public void deleteMember(String userId) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = DBUtil.getInstance().getConnection();
	        String sql = "DELETE FROM member WHERE user_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setString(1, userId);
	        
	        int rowCount = pstmt.executeUpdate();
	        
	        if (rowCount == 1) {
	            System.out.println("회원 정보가 삭제되었습니다.");
	        } else {
	            System.out.println("회원 정보 삭제에 실패했습니다. 유효한 사용자 ID를 확인하세요.");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBUtil.getInstance().close(pstmt, conn);
	    }
	}
```

# 보드 게시글 등록, 수정, 삭제, 조회

## 1. 등록
![1](/uploads/9aa04e62e23140d772cd6ea1ddae2f9a/1.PNG)
```java
public void registerArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("insert into board(user_id, subject, content)\n");
			sql.append("values( ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getUserId());
			pstmt.setString(2, boardDto.getSubject());
			pstmt.setString(3, boardDto.getContent());
			
			pstmt.executeUpdate();
			System.out.println("글쓰기 성공");
		} catch (SQLException e) {
			System.out.println("글쓰기 실패  아이디를 확인하세요 !!");
			
			//e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(pstmt,conn);
		}
	}
```

## 2. 전체 조회
![2](/uploads/b336195b05c69919ba0e8007342551bb/2.PNG)
```java
public List<BoardDto> searchListAll() {
        List<BoardDto> boardList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT * FROM board"; 
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setArticleNo(rs.getInt("article_No"));
                boardDto.setUserId(rs.getString("user_id"));
                boardDto.setSubject(rs.getString("subject"));
                boardDto.setContent(rs.getString("content"));
                boardDto.setHit(rs.getInt("hit"));
                boardDto.setRegisterTime(rs.getString("register_time"));

                boardList.add(boardDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }

        return boardList;
    }
```

## 3. 제목으로 조회
![3](/uploads/c2e4b307bad62971ff7cc011a72138dc/3.PNG)

```java
public List<BoardDto> searchListBySubject(String subject) {
        List<BoardDto> boardList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getInstance().getConnection();
            String sql = "SELECT * FROM board WHERE subject LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + subject + "%");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setArticleNo(rs.getInt("article_No"));
                boardDto.setUserId(rs.getString("user_id"));
                boardDto.setSubject(rs.getString("subject"));
                boardDto.setContent(rs.getString("content"));
                boardDto.setHit(rs.getInt("hit"));
                boardDto.setRegisterTime(rs.getString("register_time"));

                boardList.add(boardDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getInstance().close(rs, pstmt, conn);
        }

        return boardList;
    }
```

## 4. 게시글 번호로 조회
![4](/uploads/2b73dd63ef9075e415e3e9cfcbf29783/4.PNG)
```java
public BoardDto viewArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto boardDto = new BoardDto();
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select * \n");
			sql.append("from board \n");
			sql.append("where article_no =" + no);
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				cnt++;
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}
			if(cnt == 0 )
				return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return boardDto;
	}
```

## 5. 게시글 수정
![5](/uploads/5d43689a1c41a64c04a955095bef3e57/5.PNG)
```java
public void modifyArticle(BoardDto boardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "update board set subject=?, content=? where article_no=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			
			int r = pstmt.executeUpdate();
			System.out.println("변경된 row : " + r);
		} catch (SQLException e) {
            System.out.println("[SQL Error : " + e.getMessage() + "]");

        } finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}

	}
```

## 6. 게시글 삭제
![6](/uploads/76c88448699d70cf0582a5d99bc4d9a4/6.PNG)
```java
public void deleteArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			String sql = "delete from board where article_no=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			int r = pstmt.executeUpdate();
			System.out.println("변경된 row : " + r);
		} catch (SQLException e) {
            System.out.println("[SQL Error : " + e.getMessage() + "]");

        } finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}

	}
```
# ER 다이어그램
---
![13](/uploads/7d2238c2b03a172454d182dad5649131/13.JPG)

```sql
use enjoytrip;
DROP TABLE  if exists member;
DROP TABLE  if exists board;

create table member
(
    user_id VARCHAR(50) primary key,
    user_name VARCHAR(50) NULL DEFAULT NULL,
    user_password VARCHAR(50) NULL DEFAULT NULL,
    join_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

insert into member (user_id, user_name, user_password, join_date)
values 
("id1","name1","pw1",sysdate()),
("id2","name2","pw2",sysdate()),
("id3","name3","pw3",sysdate()),
("id4","name4","pw4",sysdate());

select * from member;

create table board
(
	article_no INT NOT NULL AUTO_INCREMENT primary key,
	user_id VARCHAR(16) NULL DEFAULT NULL,
    subject VARCHAR(100) NULL DEFAULT NULL,
    content VARCHAR(2000) NULL DEFAULT NULL,
    hit int NULL default 0,
    register_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT FK_1
    FOREIGN KEY(user_id)
    REFERENCES member(user_id)
);

insert into board(user_id, subject, content, register_time)
values
("id1", "주제1", "오늘은 행복한 하루", sysdate()),
("id1", "주제2", "어디로 놀러가지", sysdate()),
("id3", "주제3", "가서 뭐할까?", sysdate()),
("id4", "주제4", "우리 같이 놀러가자", sysdate());

select * from board;

```
