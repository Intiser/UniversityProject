<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\User;
use App\application;
use Auth;

class UserController extends Controller{

    public function __construct()
    {
        // $this->middleware();
    }


    public function postCreateUser(Request $request){

        $this->validate($request,[
            'type'=>'required',
            'email'=>'required|email|unique:users',
            'password'=>'required|min:8'
        ]);

        $email = $request['email'];
        $type = $request['type'];
        $password = bcrypt($request['password']);
        $user = new User();
        $user->email = $email;
        $user->type = $type;
        $user->password = $password;

        $user->save();

        return redirect()->route('user_edit');
    }

    public function postSignIn(Request $request){
        if(Auth::attempt(['email' => $request['email'], 'password' => $request['password']])){
            return redirect() ->  route('dashboard', ['user_id' =>  Auth::user()->id ]);
        }
    }

    public function getSignOut(){
        auth()->logout();
        return redirect() -> route('home');
    }

    public function editpost(){
        $users = User::all();
        $applications = application::all();
        return view('admin.user_edit',['users'=>$users],['applications'=>$applications]);
    }

    public function getUserDelete($user_id){
        $user = User::where('id', $user_id)->first();
            if (Auth::user()->type != "Admin") {
               
                return redirect()->back();
            }
           // if(Auth::user()->id == $user_id){

           // }
            $user->delete();
            return redirect()->route('user_edit')->with(['message' => 'Successfully deleted!']);
    }

}