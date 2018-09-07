@extends('master')

@section('title')
    OKAY
@endsection

@section('content')
    <div class="row">
        <div class="col-md-6">
            <h3>Sign In</h3>
            <form action="signin" method="post">
                <div class="form-group {{ $errors->has('email') ? 'has-error' : '' }}">
                    <label for="email">Your E-Mail</label>
                    <input class="form-control" type="text" name="email" id="email" value="{{ Request::old('email') }}">
                </div>
                <div class="form-group {{ $errors->has('password') ? 'has-error' : '' }}">
                    <label for="password">Your Password</label>
                    <input class="form-control" type="password" name="password" id="password" value="{{ Request::old('password') }}">
                </div>
                <button type="submit" class="btn btn-primary active">Submit</button>
                <input type="hidden" name="_token" value="{{ Session::token() }}">
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <h3>Application Form</h3>
            <form action=" {{ route('apply') }}" method="post">
                <div class="form-group {{ $errors->has('fullname') ? 'has-error' : '' }}">
                    <label for="fullname">Full Name</label>
                    <input class="form-control" type="text" name="fullname" id="fullname" value="{{ Request::old('fullname') }}">
                </div>

                <div class="form-group {{ $errors->has('email') ? 'has-error' : '' }}">
                    <label for="email">E-Mail</label>
                    <input class="form-control" type="text" name="email" id="email" value="{{ Request::old('email') }}">
                </div>

                <div class="form-group {{ $errors->has('contact') ? 'has-error' : '' }}">
                    <label for="contact">Contact Number</label>
                    <input class="form-control" type="text" name="contact" id="contact" value="{{ Request::old('contact') }}">
                </div>

                <div class="form-group {{ $errors->has('address') ? 'has-error' : '' }}">
                    <label for="address">Address</label>
                    <input class="form-control" type="text" name="address" id="address" value="{{ Request::old('address') }}">
                </div>

                <div class="form-group {{ $errors->has('nationality') ? 'has-error' : '' }}">
                    <label for="nationality">Nationality</label>
                    <input class="form-control" type="text" name="nationality" id="nationality" value="{{ Request::old('nationality') }}">
                </div>




                <button type="submit" class="btn btn-primary active">Submit</button>
                <input type="hidden" name="_token" value="{{ Session::token() }}">
            </form>
        </div>

    </div>


@endsection