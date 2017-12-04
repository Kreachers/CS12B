// $Id: filecopy.cc,v 340.38 2004-01-30 16:42:56-08 - - $

//
// NAME
//    copyfile - copy input file to output file
//
// SYNOPSIS
//    copyfile [infile [outfile]]
//
// OPTIONS
//    NONE
//
// DESCRIPTION
//    The input file is copied an unsigned byte at a time to the
//    output file.  If the output file is not specified, `cout' is
//    assumed.  If the infile is not specified, or is specified as
//    `-', `cin' is assumed.
//

#include <cerrno>
#include <cstdlib>
#include <cstring>
#include <fstream>
#include <iostream>
#include <string>

using namespace std;

/////////////////////////////////////////////////////////////////
//
// Program status class.
//
/////////////////////////////////////////////////////////////////

string basename( string &filename ){
   // see also:  <libgen.h>basename(3c)
   if( filename.size() == 0 ) return ".";
   int end = filename.find_last_not_of( "/" );
   if( end < 0 ) return "/";
   int begin = filename.find_last_of( "/", end );
   return filename.substr( begin + 1, end - begin );
};

class progstatus{
   public:
      const string progname;
      int exitcode;
      progstatus( string argv0 );
      void syserror( string &objectname );
};

progstatus::progstatus( string argv0 ):
   progname( basename( argv0 )),
   exitcode( EXIT_SUCCESS )
{};

void progstatus::syserror( string &objectname ){
   cerr << progname << ": " << objectname << ": " << strerror( errno )
        << endl;
   exitcode = EXIT_FAILURE;
};

/////////////////////////////////////////////////////////////////
//
// File copy functions.
//
/////////////////////////////////////////////////////////////////

// Print a usage message and exit.

void usage( progstatus &status ){
   cerr << "Usage: " << status.progname << " [infile [outfile]]"
        << endl;
   exit( EXIT_FAILURE );
};

// Open input file:  If missing or `-', use `cin' instead.

istream *openinfile( string &infilename, progstatus &status ){
   istream *infile = NULL;
   if( infilename == "-" ){
      infile = &cin;
   }else{
      infile = new fstream( infilename.c_str(), fstream::in );
      cerr << "******** new in ******** " << (void*) infile << endl;
      if( infile->fail() ) status.syserror( infilename );
   };
   return infile;
};

// Open output file:  If missing or `-', use `cout' instead.

ostream *openoutfile( string &outfilename, progstatus &status ){
   ostream *outfile = NULL;
   if( outfilename == "-" ){
      outfile = &cout;
   }else{
      outfile = new fstream( outfilename.c_str(), fstream::out );
      cerr << "******** new out ******** " << (void*) outfile << endl;
      if( outfile->fail() ) status.syserror( outfilename );
   };
   return outfile;
};

// Given two opened files, copy them.

void copyfile( istream &infile, ostream &outfile ){
   char sbyte;
   while( infile.good() && infile.get( sbyte )){
      //outfile << sbyte;
      outfile.put( sbyte );
   };
   outfile.flush();
};

// Close a file if it is a pointer to an fstream.

void fclose( ios *file ){
   fstream *ffile = dynamic_cast< fstream* >( file );
   if( ffile != NULL ){
      ffile->close();
      delete ffile;
      cerr << "******** delete ******** " << (void*) ffile << endl;
   };
}

// Main:  open files, copy bytes, close files.

int main( int argc, char **argv ){
   progstatus status( argv[0] );
   if( argc > 3 ) usage( status );
   string infilename = argc > 1 ? argv[1] : "-";
   string outfilename = argc > 2 ? argv[2] : "-";
   istream *infile = openinfile( infilename, status );
   ostream *outfile = openoutfile( outfilename, status );
   if( infile && outfile ) copyfile( *infile, *outfile );
   fclose( infile );
   fclose( outfile );
   return status.exitcode;
};

