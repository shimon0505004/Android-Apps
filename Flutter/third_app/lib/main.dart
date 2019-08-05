import 'package:flutter/material.dart';

void main(){
  runApp(new application());
}

class application extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        body: new Container(
          child: new Text('This is my Container'),
          height: 300.0,
          width: 300.0,
          alignment: Alignment.center,
          padding: const EdgeInsets.all(20.0),
          decoration: new BoxDecoration(
            color: Colors.green
          ),
          foregroundDecoration: new BoxDecoration(
            color: Colors.deepOrange
          ),
        ),
      )
    );
  }
}
