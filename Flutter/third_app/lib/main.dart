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
          color: Colors.pink,
          child: new Text('This is my Container'),
          height: 300.0,
          width: 300.0,
          alignment: Alignment.center,
          padding: const EdgeInsets.all(40.0),
        ),
      )
    );
  }
}
