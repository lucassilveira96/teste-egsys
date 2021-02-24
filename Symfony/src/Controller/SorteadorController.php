<?php


namespace App\Controller;

use Symfony\Component\HttpFoundation\Response;
use phpDocumentor\Reflection\DocBlock\Tags\Return_;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;


class SorteadorController extends AbstractController
{
    #[Route('/sorteador', name: 'sorteador', methods: ['GET'])]
    public function sorteador(): Response
    {
       return $this->render('sorteador/sorteador.html.twig');
    }
    #[Route('/sortear', name: 'sortear', methods: ['POST'])]
    public function sortear(Request $request): Response
    {
        $data=$request->request->all();
        $valor = random_int($data['valorMinimo'],$data['valorMaximo']);
        return $this->render('sorteador/numeroSorteado.html.twig',[
            'valor'=>$valor
        ]);
    }

}