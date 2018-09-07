<?php 
namespace App\Http\Controllers;


use Illuminate\Http\Request;
use App\News;
use App\User;
use Auth;

class NewsController extends Controller{
		public function saveNews(Request $request){
			$newsCategory = $request['newsCategory'];
			$newsPriority = $request['newsPriority'];
			$newsTitle= $request['newsTitle'];
			$newsBody = $request['newsBody'];
			$News = new news();
			$News->newsCategory = $newsCategory;
			$News->newsPriority = $newsPriority;
			$News->newsTitle = $newsTitle;
			$News->newsBody = $newsBody; 
			$request->User()->News()->save($News);
			
			return redirect()->back();
		}	

		public function editNews(Request $request){


		
			$news = News::find($request['newsId']);
			$news->newsCategory = $request['newsCategory'];
			$news->newsPriority = $request['newsPriority'];
			$news->newsTitle    = $request['newsTitle'];
			$news->newsBody     = $request['newsBody'];
			$news->update();
			
			return redirect()->route('success');
		}	

		public function loadNews($user_id){
			//dd(\App\News::where( 'user_id', $user_id )->get() );
			$news =  News::where( 'user_id', $user_id )->orderBy('id','desc')->get();
			//dd($user_id);
			//dd($news);
			return view('dashboard',['news'=>$news]);
		}

		public function newsAll(){
			
			$news =  News::orderBy('id','desc')->get();
			
			return view('welcome',['news'=>$news]);
		}

		public function getNewsDelete($news_id){
			//dd($news_id);
			$news = News::where('id', $news_id)->first();
	        if (Auth::user() != $news->user) {
	           
	            return redirect()->back();
	        }
	        $news->delete();
	        return redirect()->route('dashboard',['user_id' =>  Auth::user()->id ])->with(['message' => 'Successfully deleted!']);
		}

		public function getNewsEdit($news_id){
			//dd($news_id);
			$news = News::where('id', $news_id)->first();
	       
	        return view('edit',['news' => $news] );
		}

		public function getNewsCategory($news){
			
			$newsAll = News::where('newsCategory', $news)->get();
			if ($news == "national") {
				$msg = "National News";
			}
			elseif ($news == "international") {
				$msg = "International News";
			}
			elseif ($news == "sports") {
				$msg = "Sports News";
			}
			elseif ($news == "entertainment") {
				$msg = "Entertainment News";
			}

			return view('category',['newsAll' =>  $newsAll ], ['msg' => $msg ]);
		}

		public function getNewsfeed($news_id){
			
			$news = News::where('id', $news_id)->first();
			//$newsTop = News::where('newsPriority',"Top")->get();
			$newsAll = News::orderBy('id','desc')->get()->take(25);
			//dd($newsAl);
			return view('newsfeed',['news'=>$news],['newsAll'=> $newsAll] );
		}
		
}