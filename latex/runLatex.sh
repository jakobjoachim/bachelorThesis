#!/bin/bash

function clear {
  for i in aux idx lof log lot nlo synctex.gz toc blg bbl dvi
  do
    rm -f thesis.$i
  done
}

function copyResourcesToOut {
  cp ../*.sty .
  cp ../thesis.bib .
  cp -r ../logo .
  cp -r ../images/*.png .
  cp ../*.tex .
}

function texify {
  pdflatex -interaction=batchmode thesis.tex
}

function compile {
  texify
  bibtex thesis.aux
  # makeglossaries thesis
  texify
  texify
}

cd "out" && copyResourcesToOut && clear && compile
